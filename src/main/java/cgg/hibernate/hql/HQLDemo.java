package cgg.hibernate.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLDemo {

	public static void main(String[] args) {
		
		 SessionFactory factory=new Configuration().configure().buildSessionFactory();
		 
		 Session session = factory.openSession();
		 
		 
		 
//		 HQL
//		 Syntax
		 
//		 String query="from Student as s where s.city=:x and s.name=:n";
//		 Query q= session.createQuery(query);
//		 q.setParameter("x", "Hyd");
//		 q.setParameter("n", "sanju");
//		 
////		 Single result-(unique)
////		 multiple results-list
//		 
//		 List<Student> list = q.list();
//		 
//		 for(Student student:list) {
//			 System.out.println(student.getName()+":"+student.getCity()+":"+student.getCerti().getCourse());
//		 }
//		 
//		 System.out.println("-----------------------");
		 
//		 Transaction tx=session.beginTransaction();
		 
//		 delete query
		 
//		 Query q1=session.createQuery("delete from Student s where s.city=:x");
//		 
//		 q1.setParameter("x", q1);
//		 int r=q1.executeUpdate();
//		 System.out.println("deleted: "+r);
//		 System.out.println(r);
//		 
		 
//		 update query
//		 Query q2=session.createQuery("update StudentManage set city=:c where name=:n");
//		 q2.setParameter("c","warangal");
//		 q2.setParameter("n","sanju");
//		 int r=q2.executeUpdate();
//		 System.out.println("deleted: "+r);
		 
		 
//		 tx.commit();
		 
		 
		 
//		 how to execute join query
		 
		Query q=session.createQuery("select b.brandId,b.brandName,p.productName from Brand as b INNER JOIN b.products as p");
		List<Object []> list = q.getResultList();
		for(Object[] arr : list) {
			System.out.println(Arrays.toString(arr));
		}
		 session.close();
		 factory.close();

	}

}
