package cgg.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cgginterns.hibernate.Student;

public class HQLDemo {

	public static void main(String[] args) {
		
		 SessionFactory factory=new Configuration().configure().buildSessionFactory();
		 
		 Session session = factory.openSession();
		 
		 
		 
//		 HQL
//		 Syntax
		 
		 String query="from Student as a where s.city=:x and s.name=:n";
		 Query q= session.createQuery(query);
		 q.setParameter("x", "Hyd");
		 q.setParameter("n", "AAA");
		 
//		 Single result-(unique)
//		 multiple results-list
		 
		 List<Student> list = q.list();
		 
		 for(Student student:list) {
			 System.out.println(student.getName()+":"+student.getCity()+":"+student.getCerti().getCourse());
		 }
		 
		 
		 
		 session.close();
		 factory.close();

	}

}
