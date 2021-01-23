package com.xanxau.persistence.module06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Util {

  public static LocalDate date(String s) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate localDate = LocalDate.parse(s, formatter);
    return localDate;
  }
}
