package fr.grin.tpcustomer.managedbeans;

import fr.grin.tpcustomer.entities.Customer;
import fr.grin.tpcustomer.session.CustomerManager;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Backing bean de la page CustomerList.xhtml.
 *
 * @author grin
 */
@Named(value = "customerMBean")
@ViewScoped
public class CustomerMBean implements Serializable {

  private List<Customer> customerList;

  @EJB
  private CustomerManager customerManager;

  /**
   * Retourne la liste des clients pour affichage dans une DataTable
   *
   * @return
   */
  public List<Customer> getCustomers() {
    if (customerList == null) {
      customerList = customerManager.getAllCustomers();
    }
    return customerList;
  }

}
