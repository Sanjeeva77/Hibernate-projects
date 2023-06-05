package cgginterns.hibernate.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cgginterns.hibernate.Certificate;
import cgginterns.hibernate.Student;

public class StateDemo {

	public static void main(String[] args) {
				
		SessionFactory factory =new Configuration().configure().buildSessionFactory();
		
		Student student=new Student();
		student.setId(1414);
		student.setName("PQR");
		student.setCity("Hyd");
		student.setCerti(new Certificate("Android","2 months"));
//		student : transient
		
		Session s=factory.openSession();
		
		Transaction tx=s.beginTransaction();
		
		s.save(student);
//		student :persistent : session,database
		
		student.setName("UVW");
		  
		Student st=s.get(Student.class,1414);
		s.delete(st);
//		student : Removed State
		
		
		
		tx.commit();
		s.close();
//		student : detached
		
		
		student.setName("DEF");
		System.out.println(student.getName());
		factory.close();

	}

}
