package com.mdymen.jpaauxtable;

import com.mdymen.jpaauxtable.employee.Employee;
import com.mdymen.jpaauxtable.employee.EmployeeRepository;
import com.mdymen.jpaauxtable.entry.*;
import com.mdymen.jpaauxtable.meal.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {

    private final EntryRepository entryRepository;
    private final EmployeeRepository employeeRepository;

    @RequestMapping(path = "/v1/entry", method = RequestMethod.POST)
    public ResponseEntity<Entry> entry(@RequestBody Entry entry) {
        var entryResponse = this.entryRepository.save(entry);
        return new ResponseEntity<Entry>(entryResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/v1/entry", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Entry>> get() {
        var entries = this.entryRepository.findAll();
        return new ResponseEntity<Iterable<Entry>>(entries, HttpStatus.OK);
    }

    private final CompensationRepository compensationRepository;

    @RequestMapping(path = "/v1/entry/compensation", method = RequestMethod.POST)
    public ResponseEntity<Compensation> compensation(@RequestBody Entry entry) {
        var entryToCompensateOpt = this.entryRepository.findByCorrelation(entry.getCorrelationCompensatedBy());

        if (entryToCompensateOpt.isEmpty()) {
            throw new RuntimeException();
        }

        var entryToCompensate = entryToCompensateOpt.get();


//        this.entryRepository.save(entry);

//        entryToCompensate = this.entryRepository.save(compensation);
//        entryToCompensate.setCompensation(compensation);

        Compensation compensation = new Compensation();
        compensation.setCompensatedEntry(entryToCompensate);
//        compensation.setCompensatingEntry(entryToCompensate);
//
//        compensation = this.compensationRepository.save(compensation);

        entry.setCompensation(compensation);

//        var response = this.entryRepository.save(compensation);

//        entryToCompensate.setCompensation(compensation);
//
        this.entryRepository.save(entry);

        return new ResponseEntity<Compensation>(compensation, HttpStatus.OK);
    }

    @RequestMapping(path = "/v1/employee", method = RequestMethod.POST)
    public ResponseEntity<Employee> employee(@RequestBody Employee employee) {
        var entryResponse = this.employeeRepository.save(employee);
        return new ResponseEntity<Employee>(entryResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/v1/employee", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Employee>> getEmployee() {
        var entries = this.employeeRepository.findAll();
        return new ResponseEntity<Iterable<Employee>>(entries, HttpStatus.OK);
    }

    private final MealRepository mealRepository;
    @RequestMapping(path = "/v1/meal", method = RequestMethod.POST)
    public ResponseEntity<MealWithEmbeddedAllergens> meal() {

        MealWithEmbeddedAllergens meal = MealWithEmbeddedAllergens
                .builder()
                .price(BigDecimal.ONE)
                .name("pep")
                .description("des")
                .allergens(AllergensAsEmbeddable
                        .builder()
                        .celery(false)
                        .peanuts(true)
                        .sesameSeeds(true)
                        .build())
                .person(Person
                        .builder()
                        .name("Martin")
                        .build())
                .build();

        var response = this.mealRepository.save(meal);
        return new ResponseEntity<MealWithEmbeddedAllergens>(response, HttpStatus.OK);
    }
}
