package cgg.hibernate.cascade;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CascadeExample {

	public static void main(String[] args) {
	
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		 
		 
		 Session session=factory.openSession();
		 
		 Brand b1 = new Brand();
		 
		 b1.setBrandId(4);
		 b1.setBrandName("Samsung");
		 
		 Product p1=new Product(41,"samsung mobile");
		 
		 Product p2=new Product(42,"samsung laptops");
		 
		 Product p3=new Product(43,"samsung AC");
		 
		 ArrayList<Product> list = new ArrayList<Product>();
		 
		 list.add(p1);
		 list.add(p2);
		 list.add(p3);
		 

		 
		 b1.setProducts(list);
		 
		 Transaction tx =session.beginTransaction();
		 
		 
		 session.delete(3);
		 
		 session.save(b1);
		 
		 
		 tx.commit();
		 
		 
		 
		 
		 session.close();
		 factory.close();


	}

}
