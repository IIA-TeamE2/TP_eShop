package repository;

import org.springframework.data.repository.CrudRepository;
import entity.Customer;

/**
 * Repository of the class Customer
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
