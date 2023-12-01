package com.example.clock.service;

import com.example.clock.model.TimeRequest;

public interface TimeConversionService {
    String convertTimeToWordsAndType(TimeRequest timeRequest);
}
