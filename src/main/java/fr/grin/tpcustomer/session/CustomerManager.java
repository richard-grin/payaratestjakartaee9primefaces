package fr.grin.tpcustomer.session;

import fr.grin.tpcustomer.entities.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import jakarta.persistence.PersistenceContext;

/**
 * Gère la persistance des Customers.
 * @author grin
 */
@Stateless
public class CustomerManager {
    @PersistenceContext
    private EntityManager em;

    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        System.out.println("Les customers : ");
        List<Customer> liste = query.getResultList();
        System.out.println("************liste = " + liste);
        return liste;
//        return query.getResultList();
    }

    public Customer update(Customer customer) {
        return em.merge(customer);
    }
    
    public void persist(Customer customer) {
        em.persist(customer);
    }

}
