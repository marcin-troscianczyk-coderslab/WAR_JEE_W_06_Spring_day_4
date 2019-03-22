package pl.coderslab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@RestController
public class FreeTimeController {

    private static final int START_WORK_HOUR = 9;
    private static final int END_WORK_HOUR = 17;

    @GetMapping(path = "/freeTime", produces = "text/html; charset=UTF-8")
    public String freeTime() {

        final LocalDateTime localDateTime = LocalDateTime.parse("2019-03-14T12:00:00");
        //LocalDateTime.of(2019, 03, 14, 12, 0, 0);
        //LocalDateTime.now();
        final DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return "Wolne";
        }

        final int currentHour = localDateTime.getHour();

        if (currentHour > START_WORK_HOUR && currentHour < END_WORK_HOUR) {
            return "Pracuje, nie dzwoń.";
        } else {
            return "Po Pracy";
        }
    }
}
