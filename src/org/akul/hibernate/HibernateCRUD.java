package org.akul.hibernate;

import java.util.List;

import org.akul.dto.UserDetails;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class HibernateCRUD {

	public static void main(String[] ar){
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		//now session factory object thru which we can save a session object
		Session session = sessionFactory.openSession();
		//beginning the transaction,i can save as many transactions as i want and it defines the single unit of work
		session.beginTransaction();
		
		//below is creating
		for(int i=0;i<10;i++){
			UserDetails usermul =new UserDetails();
			usermul.setUserName("user "+i);
			usermul.setDescription("user "+i+"description");
			session.save(usermul);
		}
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
		
		
		//user.setUserName("updated");//IMPORTANT-even if we din ask hibernate to save the updated value again,hibernate did it on its own and that is why it is calld to trace the object and updation happens on its own
		
		//HQL
		//doing parameterized sql query injection
		//String min= "5";
		//create query object
		//Query query = session.createQuery("from UserDetails where userId > ?");
		//query.setInteger(0, Integer.parseInt(min));//the first parameter defines the postion at which value must be injected,i.e. in case of more than one parameters,when we want to give value to 2nd parameter we use 1 in the first argument
		//query.setFirstResult(5);//pagination start from 5th record
		//query.setMaxResults(2);//and display only 2 records
		//Query query = session.getNamedQuery("UserDetails.byId");//in case of Namedquery
		//usig criteria instead of HQL
		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eqOrIsNull("userName", "user 5"))
				.add(Restrictions.gt("userId", 3));//this is an and query
		List<UserDetails> users = (List<UserDetails>) criteria.list();
		//List<String> usernames = (List<String>) query.list();
		session.getTransaction().commit();
		
		session.close();
		for(UserDetails u : users)
		System.out.println(u.getUserName());
		
	}
}
