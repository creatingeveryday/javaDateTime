package com.practice.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class FormatTest {
    @Test
    void localDate_dateTimeFormatter() throws Exception {
        LocalDate localDate = LocalDate.of(2024, 2, 17);
        String date1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String date2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);

        LocalDate s1 = LocalDate.parse("20240217", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate s2 = LocalDate.parse("2024-02-17", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    @Test
    void localDateTime_dateTimeFormatter() throws Exception {
        LocalDateTime now = LocalDateTime.of(2024, 2, 9, 3, 55, 10);
        String date1 = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        String date2 = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String date3 = now.format(DateTimeFormatter.ISO_DATE_TIME);

        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
        System.out.println("date3 = " + date3);
    }

    @Test
    void dateTimeFormatter_custom() throws Exception {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.of(2024, 2, 17);

        String formattedDate = localDate.format(dateTimeFormatter);
        System.out.println("formattedDate = " + formattedDate);

        LocalDate parsedDate = LocalDate.parse(formattedDate, dateTimeFormatter);
        System.out.println("parsedDate = " + parsedDate);
    }

    @Test
    void dateTimeFormatter_custom_complex() throws Exception {
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
                .appendPattern("[yyyy-MM-dd'T'HH:mm:ss.SSS'Z']")
                .appendPattern("[yyyy-MM-dd HH:mm:ss]")
                .appendPattern("[yyyy-MM-dd]")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .toFormatter()
                .withZone(ZoneId.of("UTC"));

        ZonedDateTime dateTime0 = ZonedDateTime.parse("2024-02-17T18:22:41.422Z", dateTimeFormatter);
        ZonedDateTime dateTime1 = ZonedDateTime.parse("2024-02-17 11:20:55", dateTimeFormatter);
        ZonedDateTime dateTime2 = ZonedDateTime.parse("2024-02-17", dateTimeFormatter);
        System.out.println("dateTime0 = " + dateTime0);
        System.out.println("dateTime1 = " + dateTime1);
        System.out.println("dateTime2 = " + dateTime2);
    }

}
