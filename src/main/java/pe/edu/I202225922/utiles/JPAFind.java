package pe.edu.I202225922.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202225922.domain.City;
import pe.edu.I202225922.domain.Country;

import java.util.List;

public class JPAFind {


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        //obtener Country

        //Country country = em.find(Country.class, "ABW");
        // System.out.println(country.toString());

        try {
            // Buscar el país con código "PER"
            Country peru = em.find(Country.class, "PER");

            if (peru != null) {
                // Obtener todas las ciudades asociadas al país "PER"
                List<City> allCities = em.createQuery("SELECT c FROM City c WHERE c.CountryCode = :countryCode", City.class)
                        .setParameter("countryCode", peru.getCode())
                        .getResultList();

                // Usar una función lambda para filtrar ciudades con población > 700k
                allCities.stream()
                        .filter(city -> city.getPopulation() > 700000)
                        .forEach(city -> System.out.println(city.getName()));
            } else {
                System.out.println("No se encontró el país con código PER.");
            }
        } finally {
            em.close();
            emf.close();
        }
    }
    }
