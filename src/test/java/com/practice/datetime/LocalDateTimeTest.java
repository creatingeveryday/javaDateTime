package com.practice.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeTest {

    @Test
    void localDate() {
        LocalDate localDate = LocalDate.of(2024, 2, 17);
        System.out.println("localDate = " + localDate);

        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);

        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("day = " + day);
    }

    @Test
    void localTime() {
        LocalTime localTime = LocalTime.of(20, 55, 10);
        System.out.println("localTime = " + localTime);

        LocalTime now = LocalTime.now();
        System.out.println("now = " + now);

        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        int nano = now.getNano();
        System.out.println("hour = " + hour);
        System.out.println("minute = " + minute);
        System.out.println("second = " + second);
        System.out.println("nano = " + nano);
    }

    @Test
    void localDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);
    }
}
