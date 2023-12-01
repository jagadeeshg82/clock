package com.example.clock.controller;

import com.example.clock.model.TimeRequest;
import com.example.clock.service.TimeConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clock")
public class ClockController {

    private final TimeConversionService timeConversionService;

    @Autowired
    public ClockController(TimeConversionService timeConversionService) {
        this.timeConversionService = timeConversionService;
    }

    @PostMapping("/convert")
    public ResponseEntity<String> convertTimeToWordsAndType(@RequestBody TimeRequest timeRequest) {
        String result = timeConversionService.convertTimeToWordsAndType(timeRequest);
        return ResponseEntity.ok(result);
    }
}
