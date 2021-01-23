package com.xanxau.persistence.module06.demo02;

import com.xanxau.persistence.module06.Musician;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static com.xanxau.persistence.module06.Util.date;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main {

  public static void main(String[] args) {

    System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("module06-persistence-unit");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    MusicianService service = new MusicianService(em);

//    System.out.println("--- create an invalid musician ");
//    tx.begin();
//    service.createMusician(new Musician(null, null, null));
//    tx.commit();

    System.out.println("--- create a valid musician ");
    tx.begin();
    Long id = service.createMusician(new Musician("John", "Smith", date("01/01/1975")));
    tx.commit();
    em.clear();

    System.out.println("\n--- find the musician");
    System.out.println(service.findMusician(id));

    em.close();
    emf.close();
  }
}


