package com.xanxau.persistence.module06.demo01;

import com.xanxau.persistence.module06.Author;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static com.xanxau.persistence.module06.Util.date;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class AuthorServiceTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static EntityManagerFactory emf;
  private static EntityManager em;
  private static EntityTransaction tx;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @Before
  public void initEntityManager() {
    emf = Persistence.createEntityManagerFactory("module06-persistence-unit");
    em = emf.createEntityManager();
    tx = em.getTransaction();
  }

  @After
  public void closeEntityManager() {
    if (em != null) em.close();
    if (emf != null) emf.close();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldManageAuthor() {

    Author author = new Author("John", "Smith", date("01/01/1975"));
    AuthorService service = new AuthorService(em);

    // Creates and persists an author
    tx.begin();
    Long id = service.createAuthor(author);
    tx.commit();
    assertNotNull(id);

    // Finds the book by primary key
    author = service.findAuthor(id);
    assertTrue(author.getAge() >= 44);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldCheckInvalidAuthorNull() {

    Author author = new Author(null, null, null);
    AuthorService service = new AuthorService(em);

    // Creates and persists an author
    tx.begin();
    service.createAuthor(author);
    tx.commit();
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldCheckInvalidAuthorEmpty() {

    Author author = new Author("", "", null);
    AuthorService service = new AuthorService(em);

    // Creates and persists an author
    tx.begin();
    service.createAuthor(author);
    tx.commit();
  }
}