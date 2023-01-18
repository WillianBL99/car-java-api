package com.car.api.handlers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataHandler {
  private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public static LocalDate parse(String date) {
    return LocalDate.parse(date, dateFormat);
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
