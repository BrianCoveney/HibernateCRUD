package org.briancoveney.hibernate;


import org.briancoveney.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateTest {
	
	
	
	public static void main(String[] args) {
		
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
	
			// Create the SessionFactory from hibernate.cfg.xml (created only once)
			SessionFactory sessionFactory = configuration
					.buildSessionFactory(builder.build());
			//Open Session
			Session session = sessionFactory.openSession();
			
			
			session.getTransaction().begin();
			
			
			/* Create Table and Data */
			for(int i=0; i<10; i++){
				UserDetails user = new UserDetails();
				user.setUserName("User " + i);
				session.save(user);
			}
			
			/* Read */
//			UserDetails user = (UserDetails)session.get(UserDetails.class, 6);
//			System.out.println("User name pulled up is " + user.getUserName());
			
			/* Update */
//			UserDetails user = (UserDetails)session.get(UserDetails.class, 5);
//			user.setUserName("Updated User");
//			session.update(user);
			
			/* Delete */
//			UserDetails user = (UserDetails)session.get(UserDetails.class, 6);
//			session.delete(user);
		
			
			session.getTransaction().commit();
			session.close();
	}

}
