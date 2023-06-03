package cgginterns.hibernate;

import java.io.FileOutputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session=factory.openSession();
		
//		fetching student data
//		Student s=(Student)session.get(Student.class, 2);
		
		Student s=(Student)session.load(Student.class, 2);
//		load throws objectNotFoundException if object not present
//		get give null if object no exist
		
		System.out.println(s);
		
		
//		Fetching Address data
		
		Address addr=(Address)session.get(Address.class,1);
//		fetch from cache
		Address addr1=(Address)session.get(Address.class,1);
//		
//		System.out.println(addr.getStreet()+":"+addr.getCity());
//		System.out.println(addr1.getStreet()+":"+addr1.getCity());
//		
		
//		fetching image
		byte[] image=addr.getImage();
		try(FileOutputStream fos=new FileOutputStream("src/main/java/fetchedImg.jpg")){
				fos.write(image);
				fos.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	
		session.close();
		factory.close();

	}

}
