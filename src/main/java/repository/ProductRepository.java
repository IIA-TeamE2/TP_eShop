package repository;

import org.springframework.data.repository.CrudRepository;
import entity.Product;

/**
 * Repository of the class Product
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
	}
