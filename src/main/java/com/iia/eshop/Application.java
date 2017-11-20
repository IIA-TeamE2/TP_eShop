package com.iia.eshop;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import entity.Customer;
import entity.Order;
import entity.Product;
import entity.State;
import repository.CustomerRepository;
import repository.OrderRepository;
import repository.ProductRepository;

/**
 * Main application of the eShop
 */
@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private static final String String = null;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);		
	}
	@Bean
	public CommandLineRunner demo(CustomerRepository repository1, ProductRepository repository2, OrderRepository repository3) {
		return (args) -> {
			
			// Create a couple of products			
			Product product1 = new Product("Pikachu", "Souris jaune", 1, true, 2);
			Product product2 = new Product("Chenipan", "Chenille verte", 1, true, 2.99f);
			Product product3 = new Product("Ratata", "Rat violet", 100, true, 12.99f);
			Product product4 = new Product("Roucool", "Oiseau jaune et marron", 9, false, 3.99f);
			Product product5 = new Product("Dardargnan", "Grosse abeille", 11, true, 7.99f);			
			
			// Change the format of the date (from the Order Class) into a String
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");			
			
			// Create a couple of orders
			Order order1 = new Order(df.parse("02/01/2017"), State.draft, 169.99f);
			Order order2 = new Order(df.parse("02/01/2017"), State.current, 120.99f);
			Order order3 = new Order(df.parse("06/06/2017"), State.close, 120.99f);
			Order order4 = new Order(df.parse("29/09/2017"), State.draft, 120.99f);
			Order order5 = new Order(df.parse("17/03/2017"), State.close, 120.99f);

			
			// Create a couple of customers
			Customer customer1 = new Customer("Jack", "Bauer", "000", "address1", 64000, "City1", order1);
			Customer customer2 = new Customer("Chloe", "O'Brian", "001", "address2", 53000, "City2", order2);
			Customer customer3 = new Customer("Kim", "Bauer", "020", "address3", 72000, "City3", order3);
			Customer customer4 = new Customer("David", "Palmer", "300", "address4", 61000, "City4", order4);
			Customer customer5 = new Customer("Michelle", "Dessler", "4000", "address5", 35000, "City5", order5);
			
			//Insert orders in the product	
			product1.OrderAdd(order1);
			product2.OrderAdd(order2);
			product3.OrderAdd(order3);
			product4.OrderAdd(order1);
			product5.OrderAdd(order4);
		
			//Insert products in the order	
			order1.ProductAdd(product1);
			order2.ProductAdd(product2);
			order3.ProductAdd(product3);
			order4.ProductAdd(product1);
			order5.ProductAdd(product4);
			
			//Insert customers in the order
			order1.CustomerAdd(customer1);
			order2.CustomerAdd(customer2);
			order3.CustomerAdd(customer3);
			order4.CustomerAdd(customer4);
			order5.CustomerAdd(customer5);		
			
			// Save orders
			repository3.save(order1);
			repository3.save(order2);
			repository3.save(order3);
			repository3.save(order4);
			repository3.save(order5);
						
			// Save products
			repository2.save(product1);
			repository2.save(product2);
			repository2.save(product3);
			repository2.save(product4);
			repository2.save(product5);
			
			// Save customers
			repository1.save(customer1);
			repository1.save(customer2);
			repository1.save(customer3);
			repository1.save(customer4);
			repository1.save(customer5);			
		};
	}
}
