# Java 날짜와 시간 정리

- 자바 8에서 새롭게 도입된 날짜와 시간 API 클래스 특징
  - 불변 객체
  - Thread Safe

## LocalDate 날짜

```java
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
```

***결과***

```text
localDate = 2024-02-17
now = 2024-02-18
year = 2024
month = 2
day = 18
```

## LocalTime 시간

```java
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
```

***결과***

```text
localTime = 20:55:10
now = 02:53:52.178394500
hour = 2
minute = 53
second = 52
nano = 178394500
```

## LocalDateTime 날짜와 시간

```java
@Test
    void localDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);
    }
```

***결과***

```text
localDateTime = 2024-02-18T02:54:45.975094
localDate = 2024-02-18
localTime = 02:54:45.975094
```

## Instant 기계의 날짜와 시간

```java
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
```

***결과***

```text
instant = 1970-01-01T00:00:00Z

instant1.equals(instant2) = true

instant3.getEpochSecond() = 2
instant3.getNano() = 100
instant4.getEpochSecond() = 2
instant4.getNano() = 300
instant3.equals(instant4) = false

now = 2024-02-17T03:50:35.110222333Z
now.getEpochSecond() = 1708141835
now.getNano() = 110222333
```

## Duration 두 시점 사이의 기간
- between() static 메서드
  - 첫번째 파라미터기준으로 비교하여 계산
  - Duration 클래스는 초와 나노초로 시간 단위를 표현하기 때문에 LocalDate 를 파라미터로 전달할 수 없다.
  - LocalTime - LocalTime 간 비교 가능
  - LocalDateTime - LocalDateTime 간 비교 가능 
  - Instant - Instant 간 비교 가능 

```java
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
```

***결과***
```text
between.getSeconds() = 3

hours = 1
minutes = 112
seconds = 6720

betweenDayAndTime.toDays() = 3
betweenDayAndTime.toHours() = 73
betweenDayAndTime.toMinutes() = 4384
betweenDayAndTime.toSeconds() = 263090

betweenDayAndTime.toDaysPart() = 3
betweenDayAndTime.toHoursPart() = 1
betweenDayAndTime.toMinutesPart() = 4
betweenDayAndTime.toSecondsPart() = 50
```

## Period 연월일 기간

```java
@Test
void period() {
    Period between = Period.between(
            LocalDate.of(2023, 3, 10),
            LocalDate.of(2024, 2, 17));
    System.out.println("between.getYears() = " + between.getYears());
    System.out.println("between.getMonths() = " + between.getMonths());
    System.out.println("between.getDays() = " + between.getDays());

}
```

***결과***

```text
between.getYears() = 0
between.getMonths() = 11
between.getDays() = 7
```

## DateTimeFormatter 날짜와 시간 변환

### LocalDate

```java
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
```

***결과***

```text
date1 = 20240217
date2 = 2024-02-17
s1 = 2024-02-17
s2 = 2024-02-17
```

### LocalDateTime

```java
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
```

***결과***

```text
date1 = 20240209
date2 = 2024-02-09
date3 = 2024-02-09T03:55:10
```

### 패턴을 직접 정의해서 사용

```java
@Test
void dateTimeFormatter_custom() throws Exception {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate localDate = LocalDate.of(2024, 2, 17);

    String formattedDate = localDate.format(dateTimeFormatter);
    System.out.println("formattedDate = " + formattedDate);

    LocalDate parsedDate = LocalDate.parse(formattedDate, dateTimeFormatter);
    System.out.println("parsedDate = " + parsedDate);
}
```

***결과***

```text
formattedDate = 17/02/2024
parsedDate = 2024-02-17
```

### 여러 패턴의 문자열을 한번에 객체로 변환하려면?
- [API 문서](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatterBuilder.html)
- [패턴 기호 참고](https://developer.android.com/reference/java/time/format/DateTimeFormatterBuilder#appendPattern(java.lang.String))

```java
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
```

***결과***

```text
dateTime0 = 2024-02-17T18:22:41.422Z[UTC]
dateTime1 = 2024-02-17T11:20:55Z[UTC]
dateTime2 = 2024-02-17T00:00Z[UTC]
```