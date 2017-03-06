package org.akul.hibernate;

import java.util.Date;

import org.akul.dto.Address;
import org.akul.dto.FourWheeler;
import org.akul.dto.TwoWheeler;
import org.akul.dto.UserDetails;
import org.akul.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user = new UserDetails();
		Address addr = new Address();
		user.setUserName("akul2");
		//user.setAddress("noida india");
		user.setJoinedDate(new Date());
		user.setDescription("big shot!");
		addr.setCity("noida");
		addr.setPincode(201301);
		addr.setState("UP");
		addr.setStreet("sec 62");
		//user.setHomeAddress(addr);
		Address addr1 = new Address();
		addr1.setCity("noidaofc");
		addr1.setPincode(201301);
		addr1.setState("UP");
		addr1.setStreet("sec 62");
		//user.setOfcAddress(addr1);
		user.getListOfAddresses().add(addr);
		user.getListOfAddresses().add(addr1);
		
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("ford mustang");
		
		TwoWheeler cruiser = new TwoWheeler();
		cruiser.setVehicleName("avenger");
		cruiser.setSteeringHandle("easy ride");
		
		FourWheeler car =new FourWheeler();
		car.setVehicleName("BMW");
		car.setSteeringWheel("sports wheel");
		/*
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Dodge charger");
		*/
		//user.getVehicle().add(vehicle);
		//user.getVehicle().add(vehicle1);
		//vehicle.getUser().add(user);
		//vehicle1.getUser().add(user);
		
		
		//it goes to the hibernate.cfg.xml file,retrieves the session and returns the session object using buildSessionFactory()
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		//now session factory object thru which we can save a session object
		Session session = sessionFactory.openSession();
		//beginning the transaction,i can save as many transactions as i want and it defines the single unit of work
		session.beginTransaction();
		//saving the object
		//session.persist(user); //instead of session.save() we use another method persist coz of cascading
		for(int i=0;i<10;i++){
			UserDetails usermul =new UserDetails();
			usermul.setUserName("user "+i);
			usermul.setDescription("user "+i+"description");
			usermul.getListOfAddresses().add(addr);
			session.save(usermul);
		}
		session.save(user);
		session.save(vehicle);
		session.save(cruiser);
		session.save(car);
		//session.save(vehicle);
		//session.save(vehicle1);
		//ending the transaction
		session.getTransaction().commit();
		
		session.close();
		/*
		user = null;
		session = sessionFactory.openSession();
		user=(UserDetails) session.get(UserDetails.class,1);
		System.out.println(user.getListOfAddresses().size());
		session.close();*/
		/*
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		//using the above session object to fetch the values from the db
		user = (UserDetails) session.get(UserDetails.class, 1); //objects of this class are returned,second arg is the primary key of the field we want to retrieve
		System.out.println(user.getUserName());
		*/
		
	}
}
