package cgg.hibernate.firstlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cgginterns.hibernate.Student;

public class FirstLevelCacheDemo {

	public static void main(String[] args) {
		SessionFactory factory =new Configuration().configure().buildSessionFactory();
		
		Session session=factory.openSession();
		
		Student student=session.get(Student.class,14);
		
		System.out.println(student);
		
		System.out.println("Working Something");
		
		Student student1=session.get(Student.class,14);
		System.out.println(student1);
		System.out.println(session.contains(student1));
		
		
		session.close();
		factory.close();

	}

}
