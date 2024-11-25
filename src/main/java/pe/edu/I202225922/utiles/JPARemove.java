package pe.edu.I202225922.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202225922.domain.Country;

public class JPARemove {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Buscar y eliminar el país imaginario
            Country narnia = em.find(Country.class, "NAR");
            if (narnia != null) {
                em.remove(narnia);
            } else {
                System.out.println("El país 'Narnia' no se encontró en la base de datos.");
            }

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
