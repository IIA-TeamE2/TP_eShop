package repository;

import org.springframework.data.repository.CrudRepository;
import entity.Order;

/**
 * Repository of the class Order
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
