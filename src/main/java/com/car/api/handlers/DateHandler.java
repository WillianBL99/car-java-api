package com.car.api.handlers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import ch.qos.logback.classic.pattern.DateConverter;

public class DateHandler {
  private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public static Date parse(String date) {
    return Date.from(LocalDate.parse(date, dateFormat)
        .atStartOfDay().atZone(
            java.time.ZoneId.systemDefault())
        .toInstant());
  }

  public static String format(LocalDate date) {
    return date.format(dateFormat);
  }

  public static boolean isDateValid(String date) {
    try {
      parse(date);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
