package cgginterns.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program Created....." );
        
        SessionFactory factory =new Configuration().configure().buildSessionFactory();
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        
        
//      creating student object
        Student st=new Student();
        st.setId(2);
        st.setName("ABC");
        st.setCity("Hyd");
        System.out.println(st);
        
//      Creating address object
        Address ad=new Address();
        ad.setStreet("street1");
        ad.setCity("Hyd");
        ad.setOpen(true);
        ad.setX(12.88);
        ad.setAddedDate(new Date());
        
        
//		Reading Image File and Storing in Database
        try(FileInputStream fis=new FileInputStream("src/main/java/headphones.jpg")) {
        	
        	byte [] data=new byte[fis.available()];
        	fis.read(data);
        	ad.setImage(data);
        	
        }
        catch(FileNotFoundException e) {
        	e.printStackTrace();
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
        
        
        Session session = factory.openSession();
        
        session.beginTransaction();
        session.save(st);
        session.save(ad);
        session.getTransaction().commit();
        
        session.close();
        factory.close();
    }
}
