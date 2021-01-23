package com.xanxau.persistence.module06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;
import java.time.Period;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
public class Author extends Artist {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Column(name = "preferred_Language")
  private String preferredLanguage;

  // ======================================
  // =     Lifecycle Callback Methods     =
  // ======================================

  @PrePersist
  @PreUpdate
  private void validate() {
    System.out.println("DataValidationListener validate()");
    if (firstName == null || "".equals(firstName))
      throw new IllegalArgumentException("Invalid first name");
    if (lastName == null || "".equals(lastName))
      throw new IllegalArgumentException("Invalid last name");
  }

  @PostLoad
  @PostPersist
  @PostUpdate
  public void calculateAge() {
    if (dateOfBirth == null) {
      age = null;
      return;
    }

    age =  Period.between(dateOfBirth, LocalDate.now()).getYears();
  }

  // ======================================
  // =            Constructors            =
  // ======================================

  public Author() {
  }

  public Author(String firstName, String lastName, LocalDate dateOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getPreferredLanguage() {
    return preferredLanguage;
  }

  public void setPreferredLanguage(String preferredLanguage) {
    this.preferredLanguage = preferredLanguage;
  }

  // ======================================
  // =    hashcode, equals & toString     =
  // ======================================

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Author author = (Author) o;

    if (preferredLanguage != author.preferredLanguage) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (preferredLanguage != null ? preferredLanguage.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Author{");
    sb.append("id=").append(id);
    sb.append(", firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", dateOfBirth=").append(dateOfBirth);
    sb.append(", age=").append(age);
    sb.append('}');
    return sb.toString();
  }
}