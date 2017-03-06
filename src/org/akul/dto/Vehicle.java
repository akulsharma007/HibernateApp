package org.akul.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
/*@DiscriminatorColumn(
		name="VEHICLE_TYPE",//discriminator column has the name VEHICLE_TYPE
		discriminatorType=DiscriminatorType.STRING
		)//this prints class name as the discriminator by default and to change it to some other value string we use discrimator value annotation in TwoWheeler class*/
public class Vehicle {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;
	//@ManyToMany //(mappedBy="vehicle")
	
	/*private Collection<UserDetails> user = new ArrayList<UserDetails>();
	
	public Collection<UserDetails> getUser() {
		return user;
	}
	public void setUser(Collection<UserDetails> user) {
		this.user = user;
	}
	*/
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
}
