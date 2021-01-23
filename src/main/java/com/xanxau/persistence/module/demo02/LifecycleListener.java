package com.xanxau.persistence.module06.demo02;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class LifecycleListener {

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @PrePersist
  void prePersist(Object object) {
    System.out.println(".LifecyleListener       prePersist()");
  }

  @PostPersist
  void postPersist(Object object) {
    System.out.println(".LifecyleListener       postPersist()");
  }

  @PreUpdate
  void preUpdate(Object object) {
    System.out.println(".LifecyleListener       preUpdate()");
  }

  @PostUpdate
  void postUpdate(Object object) {
    System.out.println(".LifecyleListener       postUpdate()");
  }

  @PreRemove
  void preRemove(Object object) {
    System.out.println(".LifecyleListener       preRemove()");
  }

  @PostRemove
  void postRemove(Object object) {
    System.out.println(".LifecyleListener       postRemove()");
  }

  @PostLoad
  void postLoad(Object object) {
    System.out.println(".LifecyleListener       postLoad()");
  }
}