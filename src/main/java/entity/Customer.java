package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Customer Entity
 */
@Entity
public class Customer {
	
	/**Identifier of the customer **/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;	

	/** Last name of Customer */
	@Column
	private String lastName;
	
	/** First name of Customer */
	@Column
	private String firstName;
	
	/** Phone number of Customer */
	@Column
	private String phone;
	
	/** Address of Customer */
	@Column
	private String address;
	
	/** CP of Customer */
	@Column
	private int cp;
	
	/** City of Customer */
	@Column
	private String city;
	
	/**
	 * Association with Order Entity
	 * Relation (1,n)
	 */
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="Order_Id")
	private Order order;
	
	/**
	 * @return order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	
	/**
	 * Empty constructor
	 */
	protected Customer() {}	
	
	/**
	 * Constructor for the class Customer
	 * 
	 * @param lastName		lastname of this customer
	 * @param firstName		firstname of this customer
	 * @param phone			phone number of this customer
	 * @param address		address of this customer
	 * @param cp			cp of this customer
	 * @param city			city's name of this customer
	 */
	public Customer(String lastName, String firstName, String phone, String address, int cp, String city, Order order) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.phone = phone;
		this.address = address;
		this.cp = cp;
		this.city = city;
		this.order = order;
	}

	/**
	 * Return information of the customer in a String
	 */
	@Override
	 public String toString() {
	        return String.format(
	                "Customer[id=%d, firstName='%s', lastName='%s', phone='%s', address='%s', cp=%d, city='%s']",
	                id, firstName, lastName, phone, address, cp, city);
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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the phone number
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the cp
	 */
	public int getCp() {
		return cp;
	}
	/**
	 * @param cp the cp to set
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
}