package cgg.hibernate.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {

	public static void main(String[] args) {
		 SessionFactory factory=new Configuration().configure().buildSessionFactory();
		 
		 
		 Session session=factory.openSession();
		 
//		 SQL Query
		 
		 String query="select * from student";
		 
		 
		 NativeQuery nq=session.createNativeQuery(query);
		 
		 nq.setFirstResult(0);
		 
		 nq.setMaxResults(10);
		 
		 List<Object[]> list=nq.list();
		  
		 for(Object[] objects : list) {
//			 System.out.println(Arrays.toString(objects));
			 System.out.println(objects[0]+" : "+objects[1]);
		 }
		 
		 
		 session.close();
		 factory.close();

	}

}
