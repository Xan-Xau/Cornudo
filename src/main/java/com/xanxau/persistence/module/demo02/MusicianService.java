package com.xanxau.persistence.module06.demo02;

import com.xanxau.persistence.module06.Musician;

import javax.persistence.EntityManager;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class MusicianService {

  // ======================================
  // =             Attributes             =
  // ======================================

  private EntityManager em;

  // ======================================
  // =            Constructors            =
  // ======================================

  public MusicianService(EntityManager em) {
    this.em = em;
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  public Long createMusician(Musician musician) {
    em.persist(musician);
    return musician.getId();
  }

  public void removeMusician(Musician musician) {
    em.remove(em.merge(musician));
  }

  public Musician findMusician(Long id) {
    return em.find(Musician.class, id);
  }
}