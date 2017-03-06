package org.akul.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;










import java.util.Set;
import java.util.HashSet;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
//import javax.persistence.Transient;

//name property of annotation @Entity creates table with name property as against the default case value of class name
@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) //generates this aurrogate key automatically
	@Column (name="USER_ID")
	private int userId;
	/*//@Transient annotation tells hibernate to ignore userName from persisting into the database
	@Transient*/
	private String userName;
	//it only saves the date and not the timestamp
	@Temporal (TemporalType.DATE)
	private Date joinedDate;
	public Date getJoinedDate() {
		return joinedDate;
	}
	//@ManyToMany
	@OneToMany(cascade=CascadeType.PERSIST) //cascade automatically saves these vehicle collection objects without having to save them individually using session.save(vehicle) and so on
	private Collection<Vehicle> vehicle=new ArrayList<Vehicle>();

	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	//used in case of large objects to not restrict the limit of object sizei.e. description can be very large exceeding the permissible 255 varchar of database which wud result in an error
	@Lob
	private String description;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column (name="USER_NAME")
	public String getUserName() {
		return userName + "from getter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@ElementCollection(fetch=FetchType.LAZY) //this tells hibernate that we are using a collection and lazy fetch type is by default
	@JoinTable(name="USER_ADDRESS",
			joinColumns=@JoinColumn(name="USER_ID")
			)
	@GenericGenerator(name="sequence-gen",strategy="sequence") //sequence is a type of hibernate generator
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "sequence-gen", type = @Type(type="long"))//unique primary key for address table
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	
	/*@Embedded//another clue for hibernate to know its an embeddable object
	@AttributeOverrides({
	@AttributeOverride (name="street",column=@Column(name="HOME_STREET_NAME")),
	@AttributeOverride (name="city",column=@Column(name="HOME_CITY_NAME")),
	@AttributeOverride (name="state",column=@Column(name="HOME_STATE_NAME")),					
	@AttributeOverride (name="pincode",column=@Column(name="HOME_PINCODE_NAME")),		
	})//this overrides the default column name given in the Address class so as to make specific home address column name
	private Address homeAddress;
	
	private Address ofcAddress;
	
	

	public Address getHomeAddress() {
		return homeAddress;
	}


	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}


	public Address getOfcAddress() {
		return ofcAddress;
	}


	public void setOfcAddress(Address ofcAddress) {
		this.ofcAddress = ofcAddress;
	}
*/

}
