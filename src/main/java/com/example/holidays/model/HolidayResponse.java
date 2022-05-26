package com.example.holidays.model;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class HolidayResponse implements Serializable {
    @NotBlank
    private String date;
    @NotBlank
    private String name;
    @NotBlank
    private String countryCode;

    public HolidayResponse(String date, String name, String countryCode) {
        this.date = date;
        this.name = name;
        this.countryCode = countryCode;
    }

    public HolidayResponse() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "HolidayResponse{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
