package com.example.clock.service;

import com.example.clock.exception.UserInputFormatException;
import com.example.clock.model.TimeRequest;
import com.example.clock.util.NumberToWordsConverter;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeConversionServiceImpl implements TimeConversionService {

    @Override
    public String convertTimeToWordsAndType(TimeRequest timeRequest) {
        validateUserInputFormat(timeRequest.getTime());

        LocalTime userTime = LocalTime.parse(timeRequest.getTime(), DateTimeFormatter.ofPattern("HH:mm"));
        String timeInWords;
        String type;

        if (isMidnight(userTime)) {
            timeInWords = "It's zero minute";
            type = "Midnight";
        } else if (isMidday(userTime)) {
            timeInWords = "It's zero minute";
            type = "Midday";
        } else {
            timeInWords = convertTimeToWords(userTime);
            type = "";
        }

        return "Converted Time: " + timeInWords + (type.isEmpty() ? "" : "\nType: " + type);
    }

    private String convertTimeToWords(LocalTime time) {
        int hour = time.getHour();
        int minute = time.getMinute();

        String hourInWords = NumberToWordsConverter.convertNumberToWords(hour);
        String minuteInWords = NumberToWordsConverter.convertNumberToWords(minute);

        return "It's " + hourInWords + " " + (minute > 0 ? minuteInWords + " " : "") + (minute > 1 ? "minutes" : "");
    }

    private boolean isMidnight(LocalTime time) {
        return time.equals(LocalTime.MIDNIGHT);
    }

    private boolean isMidday(LocalTime time) {
        return time.equals(LocalTime.NOON);
    }

    private void validateUserInputFormat(String userInput) {
        try {
            LocalTime.parse(userInput, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (Exception e) {
            throw new UserInputFormatException("Invalid time format. Please use the format HH:mm");
        }
    }
}
