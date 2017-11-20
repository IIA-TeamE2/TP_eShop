package entity;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Order Entity
 */
@Entity
public class Order {
	
	/** Identifier of the order **/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	/** Date of shopping */
	@Column
	private Date date;
	
	/** State of the order **/
	@Enumerated(EnumType.STRING)
	@Column
	private State state;
	
	/** Total price of the order **/
	@Column
	private float totalPrice;

	/**
	 * Constructor of the class Order
	 * @param date		 	date of the shopping of this order
	 * @param state			state of this order
	 * @param totalPrice	total of the price of this order
	 */
	public Order(Date date, State state, float totalPrice) {
		super();
		this.date = date;
		this.state = state;
		this.totalPrice = totalPrice;
	}

	/**
	 * Return information of the order in a String
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", state=" + state + ", totalPrice=" + totalPrice + "]";
	}
	
	/**
	 * Association with Order Entity
	 * Relation (1,n)
	 */
	@OneToMany(mappedBy="Customer")
	private Set<Customer> customers;
	
	/**
	 * @return customers
	 */
	public Set<Customer> getCustomers() {
		return this.customers;
	}

	/**
	 * 
	 * @param customers
	 */
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	/**
	 * 
	 * @param customer
	 */
	public void CustomerAdd(Customer customer) {
		this.customers.add(customer);
	}
	
	/**
	 * Association with Product Entity
	 * Relation (n,n)
	 */
	@ManyToMany(targetEntity = Product.class, mappedBy = "Product", cascade=CascadeType.MERGE)
	@JoinTable(name = "order_product",
			joinColumns = @JoinColumn(name = "order_Id", referencedColumnName = "order_Id"),
			inverseJoinColumns = @JoinColumn(name = "product_Id", referencedColumnName = "product_Id"))
	
	private Set<Product> products;
	
	public void ProductAdd(Product product) {
		this.products.add(product);
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the state
	 */
	public Enum getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
	/**
	 * @return the totalPrice
	 */
	public float getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	
}
