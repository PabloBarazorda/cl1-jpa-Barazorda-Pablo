package pe.edu.I202225922.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202225922.domain.City;
import pe.edu.I202225922.domain.Country;
import pe.edu.I202225922.domain.Countrylanguage;

public class JPAPersist {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            // Creamos el país
            Country narnia = new Country("NAR", "Narnia", "Asia", "Islandia", 10000.0, 2022, 5000000.0, 80.0, 20000.0, 15000.0, "Noruega", "República", "Nashville", 1.0, "NR");

            // Crear ciudades
            City city1 = new City(5001.0, "Ciudad Gotica", "NAR", "Centro", 8600.0);
            City city2 = new City(5002.0, "Nuevo Laredo", "NAR", "Norte", 7120.0);
            City city3 = new City(5003.0, "Liberty City", "NAR", "Sur", 7500.0);

            // Crear lenguajes
            Countrylanguage lang1 = new Countrylanguage("NAR", "Japones", "T", 50.0);
            Countrylanguage lang2 = new Countrylanguage("NAR", "English", "T", 83.0);

            // Persistir el país y las ciudades, lenguajes asociados
            em.persist(narnia);
            em.persist(city1);
            em.persist(city2);
            em.persist(city3);
            em.persist(lang1);
            em.persist(lang2);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
