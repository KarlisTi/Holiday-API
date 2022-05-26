package com.example.holidays.service;
import com.example.holidays.model.HolidayResponse;
import com.example.holidays.handler.RestTemplateResponseErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class HolidayService {

    private final RestTemplate restTemplate;

    public HolidayService(RestTemplateBuilder restTemplateBuilder) {
       this.restTemplate  = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }


    public HolidayResponse[] callRestService(String countryCode, String year) {
        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("code", countryCode);
        uriParams.put("year", year);
            return restTemplate.getForObject("https://date.nager.at/api/v3/publicholidays/{year}/{code}", HolidayResponse[].class, uriParams);
        }


    public List<HolidayResponse> commonHolidays(String country, String country2, String year) throws RuntimeException{
        List<HolidayResponse[]> holidays = new ArrayList<>();
        List<HolidayResponse> newHolidays = new ArrayList<>();
        holidays.add(callRestService(country, year));
       holidays.add(callRestService(country2, year));
            for (HolidayResponse[] eacHoliday : holidays) {
                for (HolidayResponse value : eacHoliday) {
                    if (value.getDate().substring(0, 4).equals(year)) {
                        newHolidays.add(value);
                    }
                }
            }
            return newHolidays;
        }
    }
