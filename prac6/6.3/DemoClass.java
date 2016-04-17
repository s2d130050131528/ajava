package com.nidhi;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
public class DemoClass {
		public static void main(String[] args) {  
	    Configuration cfg = new Configuration();  
	    cfg.configure("hibernate.cfg.xml");
SessionFactory factory = cfg.buildSessionFactory();  
	    Session session=factory.openSession();  
	    Transaction transaction = session.beginTransaction();
	    Number count = (Number) session.createQuery("select count(*) from UserDetails").uniqueResult();
	    System.out.println("Number of records in the UserDetails table: "+count);
	    count = (Number) session.createQuery("select count(*) from UserDetails where userid > 5").uniqueResult();
    System.out.println("Number of records in the UserDetails table: "+count);
	    Query query=session.createQuery("from UserDetails where userid >= 5");
	    List<UserDetails> users = query.list();
	    System.out.println("User with the userId >= 5 ");
	    for(UserDetails user : users){
	    	System.out.println("Name: "+user.getUserName());	    }   
	    transaction.commit();//transaction is committed  
	    session.close();	}	}
