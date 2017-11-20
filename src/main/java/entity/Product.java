package entity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Product Entity
 */
@Entity
public class Product {
	
	/** Identifier if the product **/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/** Name of the product **/
	@Column
	private String name;
	
	/** Description of the product **/
	@Column
	private String description;
	
	/** Quantity of the product **/
	@Column
	private int quantity;
	
	/** Boolean of the product **/
	@Column
	private boolean dead;
	
	/** Price of the product **/
	@Column
	private float price;
	
	/**
	 * Empty constructor
	 */
	protected Product() {}

	/**
	 * Constructor of the class Product
	 * @param name			name of this product
	 * @param description	description of this product
	 * @param quantity		quantity of this product
	 * @param dead			dead of this product
	 * @param price			price of this product
	 */
	public Product(String name, String description, int quantity, boolean dead, float price) {
		super();
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.dead = dead;
		this.price = price;
	}

	/**
	 * Return information of the product in a String
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
				+ ", dead=" + dead + ", price=" + price + "]";
	}

	/**
	 * Association with Order Entity
	 * Relation (n,n)
	 */
	@ManyToMany(targetEntity = Order.class, mappedBy = "Products", cascade=CascadeType.MERGE)
	
	private Set<Order> orders;
	
	/**
	 * @return orders
	 */
	public Set<Order> getOrders() {
		return orders;
	}
	
	/**
	 * 
	 * @param orders
	 * @return
	 */
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	/**
	 * @param order
	 */
	public void OrderAdd(Order order) {
		this.orders.add(order);
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the dead
	 */
	public boolean getDead() {
		return dead;
	}
	/**
	 * @param dead the dead to set
	 */
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
}
