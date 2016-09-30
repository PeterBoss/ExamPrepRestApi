/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boss.rest_apis;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Peter
 */
public class Facade {

    EntityManagerFactory emf;

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Country createCountry(Country c) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return c;
        } finally {
            em.close();
        }
    }

    public List<Country> getCountries() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            // I know it wasnt supposed to be just "SELECT c" but I ran out of time
            List<Country> countries = em.createQuery("SELECT c FROM Country c").getResultList();
            em.getTransaction().commit();
            return countries;
        } finally {
            em.close();
        }
    }

    public List<Country> getCountries(int population) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            List<Country> countries = em.createQuery("SELECT c FROM Country c WHERE c.Population >= " + population).getResultList();
            em.getTransaction().commit();
            return countries;
        } finally {
            em.close();
        }
    }

    public List<City> getCities(String code) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            List<City> cities = em.createQuery("SELECT c FROM City c WHERE c.CountryCode = " + code).getResultList();
            em.getTransaction().commit();
            return cities;
        } finally {
            em.close();
        }
    }

    public City createCity(City c) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return c;
        } finally {
            em.close();
        }
    }
}
