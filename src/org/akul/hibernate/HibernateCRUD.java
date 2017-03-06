package org.akul.hibernate;

import org.akul.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCRUD {

	public static void main(String[] ar){
		UserDetails user = new UserDetails();
		user.setUserName("user" );
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		//now session factory object thru which we can save a session object
		Session session = sessionFactory.openSession();
		//beginning the transaction,i can save as many transactions as i want and it defines the single unit of work
		session.beginTransaction();
		/*
		//below is creating
		for(int i=0;i<10;i++){
			UserDetails usermul =new UserDetails();
			usermul.setUserName("user "+i);
			usermul.setDescription("user "+i+"description");
			session.save(usermul);
		}*/
		/*
		//fetching of data after creating
		UserDetails user = (UserDetails)session.get(UserDetails.class, 6);//second argument is the primary key value for which we need to fetch data
		//deleting user
		session.delete(user);*/
		//updating user
		/*UserDetails user = (UserDetails)session.get(UserDetails.class, 2);
		user.setUserName("updated user");
		session.update(user);*/
		//ending the transaction
		session.save(user);
		
		user.setUserName("updated");//IMPORTANT-even if we din ask hibernate to save the updated value again,hibernate did it on its own and that is why it is calld to trace the object and updation happens on its own
		session.getTransaction().commit();
		
		session.close();
		
		
	}
}
