package cgginterns.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		
//		create student object
		
		Student student =new Student();
		student.setId(101);
		student.setName("ABC");
		student.setCity("Hyd");
		
//		create certificate Object....
		
		Certificate certi = new Certificate();
		certi.setCourse("Android");
		certi.setDuration("2 months");
		student.setCerti(certi);
		System.out.println(student);
		
//		creating another student object
		Student student1 =new Student();
		student1.setId(102);
		student1.setName("ABC");
		student1.setCity("Hyd");
		
//		create certificate Object....
		
		Certificate certi1 = new Certificate();
		certi1.setCourse("Hibernate");
		certi1.setDuration("1.5 months");
		student1.setCerti(certi1);
		System.out.println(student1);
		
		
		Session session =factory.openSession();
		
		session.beginTransaction();
		session.getTransaction();
		
		
		
		
		session.close();
		factory.close();

	}

}
