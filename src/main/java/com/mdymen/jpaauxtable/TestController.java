package com.mdymen.jpaauxtable;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {

    private final EntryRepository entryRepository;

    @RequestMapping(path = "/v1/entry", method = RequestMethod.POST)
    public ResponseEntity<Entry> entry(@RequestBody Entry entry) {
        var entryResponse = this.entryRepository.save(entry);
        return new ResponseEntity<Entry>(entryResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/v1/entry", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Entry>> get(@RequestBody Entry entry) {
        var entries = this.entryRepository.findAll();
        return new ResponseEntity<Iterable<Entry>>(entries, HttpStatus.OK);
    }

    @RequestMapping(path = "/v1/entry/compensation", method = RequestMethod.POST)
    public ResponseEntity<Void> compensation(@RequestBody Entry entry) {
        var entryToCompensateOpt = this.entryRepository.findByCorrelation(entry.getCorrelationCompensatedBy());

        if (entryToCompensateOpt.isEmpty()) {
            throw new RuntimeException();
        }

        var entryToCompensate = entryToCompensateOpt.get();

        Compensation compensation = Compensation
                .builder()
                .compensatedBy(entry)
                .compensatedEntry(entryToCompensate)
                .build();

        entry.setCompensation(compensation);

        this.entryRepository.save(entry);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
