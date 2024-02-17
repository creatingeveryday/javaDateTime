package com.practice.datetime;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class InstantTest {

    @Test
    void instant() throws Exception {

        // 1970-01-01T00:00:00Z 기준
        // 나노초의 정밀도를 제공한다.
        Instant instant = Instant.ofEpochSecond(0);
        System.out.println("instant = " + instant);

        Instant instant1 = Instant.ofEpochSecond(2, 1_000_000_000);
        Instant instant2 = Instant.ofEpochSecond(4, -1_000_000_000);
        System.out.println("instant1.equals(instant2) = " + instant1.equals(instant2));

        Instant instant3 = Instant.ofEpochSecond(2, 100);
        Instant instant4 = Instant.ofEpochSecond(2, 300);
        System.out.println("instant3.getEpochSecond() = " + instant3.getEpochSecond());
        System.out.println("instant3.getNano() = " + instant3.getNano());
        System.out.println("instant4.getEpochSecond() = " + instant4.getEpochSecond());
        System.out.println("instant4.getNano() = " + instant4.getNano());
        System.out.println("instant3.equals(instant4) = " + instant3.equals(instant4));

        Instant now = LocalDateTime.of(2024,2,17,3,50,35,110_222_333).toInstant(ZoneOffset.UTC);
        System.out.println("now = " + now);
        System.out.println("now.getEpochSecond() = " + now.getEpochSecond());
        System.out.println("now.getNano() = " + now.getNano());


    }
}
