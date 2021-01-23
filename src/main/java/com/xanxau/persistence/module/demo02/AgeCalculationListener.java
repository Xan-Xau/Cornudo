package com.xanxau.persistence.module06.demo02;

import com.xanxau.persistence.module06.Artist;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import java.time.LocalDate;
import java.time.Period;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class AgeCalculationListener {

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @PostLoad
  @PostPersist
  @PostUpdate
  public void calculateAge(Artist artist) {
    System.out.println(".AgeCalculationListener calculateAge()");
    if (artist.getDateOfBirth() == null) {
      artist.setAge(null);
      return;
    }

    artist.setAge(Period.between(artist.getDateOfBirth(), LocalDate.now()).getYears());
  }
}