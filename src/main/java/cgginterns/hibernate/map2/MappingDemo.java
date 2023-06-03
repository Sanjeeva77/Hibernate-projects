package cgginterns.hibernate.map2;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		 Employee emp = new Employee();
		 emp.setEmpId(1);
		 emp.setEmpId(1);
		 emp.setEmpName("abc");
		 
		 
		 Employee emp1=new Employee();
		 emp1.setEmpId(2);
		 emp1.setEmpName("xyz");
		 
		 Project pro=new Project();
		 pro.setProject_id(11);
		 pro.setProjectName("Library management");
		 
		 Project pro1=new Project();
		 pro1.setProject_id(22);
		 pro1.setProjectName("Chat Bot");
		 
		 ArrayList<Employee> list1=new ArrayList<Employee>();
		 
		 list1.add(emp);
		 list1.add(emp1);
		 
		 ArrayList <Project> list2 = new ArrayList<Project>();
		 
		 list2.add(pro);
		 list2.add(pro1);
		 
		 
		 emp.setProjects(list2);
		 pro1.setEmployees(list1);
		 
		 Session session=factory.openSession();
		 
		 Transaction tx=session.beginTransaction();
		 
		 session.save(emp);
		 
		 session.save(emp1);
		 session.save(pro);
		 session.save(pro1);
		 
		 tx.commit();
		 
		 session.close();
		 factory.close();
		 
		 

	}

}
