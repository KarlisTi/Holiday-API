package com.example.holidays.controller;

import com.example.holidays.model.HolidayResponse;
import com.example.holidays.service.HolidayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myperfectapp")
public class HolidayController {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }


    @Operation(summary = "Common holidays for two countries")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the countries",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = HolidayResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid country code or year supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Country not found",
                    content = @Content)})


    @GetMapping("/{countryCode}/{countryCode2}/{year}")
    public @ResponseBody List<HolidayResponse> getHolidays(@PathVariable String countryCode, @PathVariable String countryCode2, @PathVariable String year) {
        return holidayService.commonHolidays(countryCode, countryCode2, year);
    }
}
