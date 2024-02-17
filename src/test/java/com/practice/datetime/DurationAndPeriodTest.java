package com.practice.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;

public class DurationAndPeriodTest {

    @Test
    void duration() {
        Duration betweenSecond = Duration.between(Instant.now().minusSeconds(3), Instant.now());
        System.out.println("between.getSeconds() = " + betweenSecond.getSeconds());

        Duration betweenTime = Duration.between(
                LocalTime.of(13, 5, 5),
                LocalTime.of(14, 57, 5));
        long hours = betweenTime.toHours();
        long minutes = betweenTime.toMinutes();
        long seconds = betweenTime.toSeconds();
        System.out.println("hours = " + hours);
        System.out.println("minutes = " + minutes);
        System.out.println("seconds = " + seconds);

        Duration betweenDayAndTime = Duration.between(
                LocalDateTime.of(2024, 2, 10, 2, 10, 30),
                LocalDateTime.of(2024, 2, 13, 3, 15, 20));

        System.out.println("betweenDayAndTime.toDays() = " + betweenDayAndTime.toDays());
        System.out.println("betweenDayAndTime.toHours() = " + betweenDayAndTime.toHours());
        System.out.println("betweenDayAndTime.toMinutes() = " + betweenDayAndTime.toMinutes());
        System.out.println("betweenDayAndTime.toSeconds() = " + betweenDayAndTime.toSeconds());

        System.out.println("betweenDayAndTime.toDaysPart() = " + betweenDayAndTime.toDaysPart());
        System.out.println("betweenDayAndTime.toHoursPart() = " + betweenDayAndTime.toHoursPart());
        System.out.println("betweenDayAndTime.toMinutesPart() = " + betweenDayAndTime.toMinutesPart());
        System.out.println("betweenDayAndTime.toSecondsPart() = " + betweenDayAndTime.toSecondsPart());
    }

    @Test
    void period() {
        Period between = Period.between(
                LocalDate.of(2023, 3, 10),
                LocalDate.of(2024, 2, 17));
        System.out.println("between.getYears() = " + between.getYears());
        System.out.println("between.getMonths() = " + between.getMonths());
        System.out.println("between.getDays() = " + between.getDays());

    }
}
