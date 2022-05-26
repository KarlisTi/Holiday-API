package com.example.holidays;

import com.example.holidays.model.HolidayResponse;
import com.example.holidays.service.HolidayService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = HolidayService.class)
public class HolidayTest {

    @Autowired
    private HolidayService holidayService;
    private MockRestServiceServer mockServer;

    public HolidayTest(MockRestServiceServer mockServer) {
        this.mockServer = mockServer;
    }

    @Test
    public void shouldReturnArrayOfObejcts() {

        String result = """
                [
                {
                "date": "2017-01-01",
                "localName": "Jaunais Gads",
                "name": "New Year's Day",
                "countryCode": "LV",
                "fixed": true,
                "global": true,
                "counties": null,
                "launchYear": null,
                "types": [
                "Public"
                ]
                },
                {
                "date": "2017-04-14",
                "localName": "Lielā Piektdiena",
                "name": "Good Friday",
                "countryCode": "LV",
                "fixed": false,
                "global": true,
                "counties": null,
                "launchYear": null,
                "types": [
                "Public"
                ]
                },
                {
                "date": "2017-04-16",
                "localName": "Lieldienas",
                "name": "Easter Sunday",
                "countryCode": "LV",
                "fixed": false,
                "global": true,
                "counties": null,
                "launchYear": null,
                "types": [
                "Public"
                ]
                },
                {
                "date": "2017-04-17",
                "localName": "Otrās Lieldienas",
                "name": "Easter Monday",
                "countryCode": "LV",
                "fixed": false,
                "global": true,
                "counties": null,
                "launchYear": null,
                "types": [
                "Public"
                ]
                },
                {
                "date": "2017-05-01",
                "localName": "Darba svētki",
                "name": "Labour Day",
                "countryCode": "LV",
                "fixed": true,
                "global": true,
                "counties": null,
                "launchYear": null,
                "types": [
                "Public"
                ]
                },
                {
                "date": "2017-05-04",
                "localName": "Latvijas Republikas Neatkarības atjaunošanas diena",
                "name": "Restoration of Independence day",
                "countryCode": "LV",
                "fixed": true,
                "global": true,
                "counties": null,
                "launchYear": null,
                "types": [
                "Public"
                ]
                },
                {
                "date": "2017-05-14",
                "localName": "Mātes diena",
                "name": "Mother's day",
                "countryCode": "LV",
                "fixed": false,
                "global": true,
                "counties": null,
                "launchYear": null,
                "types": [
                "Public"
                ]
                },
                {
                "date": "2017-06-23",
                "localName": "Līgo Diena",
                "name": "Midsummer Eve",
                "countryCode": "LV",
                "fixed": true,
                "global": true,
                "counties": null,
                "launchYear": null,
                "types": [
                "Public"
                ]
                },
                {
                "date": "2017-06-24",
                "localName": "Jāņi",
                "name": "Midsummer Day",
                "countryCode": "LV",
                "fixed": true,
                "global": true,
                "counties": null,
                "launchYear": null,
                "types": [
                "Public"
                ]
                },
                {
                "date": "2017-11-18",
                "localName": "Latvijas Republikas proklamēšanas diena",
                "name": "Proclamation Day of the Republic of Latvia",
                "countryCode": "LV",
                "fixed": true,
                "global": true,
                "counties": null,
                "launchYear": null,
                "types": [
                "Public"
                ]
                },
                {
                "date": "2017-12-24",
                "localName": "Ziemassvētku vakars",
                "name": "Christmas Eve",
                "countryCode": "LV",
                "fixed": true,
                "global": true,
                "counties": null,
                "launchYear": null,
                "types": [
                "Public"
                ]
                },
                {
                "date": "2017-12-25",
                "localName": "Ziemassvētki",
                "name": "Christmas Day",
                "countryCode": "LV",
                "fixed": true,
                "global": true,
                "counties": null,
                "launchYear": null,
                "types": [
                "Public"
                ]
                },
                {
                "date": "2017-12-26",
                "localName": "Otrie Ziemassvētki",
                "name": "St. Stephen's Day",
                "countryCode": "LV",
                "fixed": true,
                "global": true,
                "counties": null,
                "launchYear": null,
                "types": [
                "Public"
                ]
                },
                {
                "date": "2017-12-31",
                "localName": "Vecgada vakars",
                "name": "New Year's Eve",
                "countryCode": "LV",
                "fixed": true,
                "global": true,
                "counties": null,
                "launchYear": null,
                "types": [
                "Public"
                ]
                }
                ]
                """;

        this.mockServer
                .expect(MockRestRequestMatchers.requestTo("https://date.nager.at/api/v3/publicholidays/2017/LV"))
                .andRespond(MockRestResponseCreators.withSuccess("result", MediaType.APPLICATION_JSON));

        HolidayResponse[] resposne = holidayService.callRestService("LV", "2017");


    }

}


