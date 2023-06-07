package cgg.hibernate.studentmanagement;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		
		SessionFactory factory =new Configuration().configure().buildSessionFactory();
		
		Session session =factory.openSession();
		
		StudentMethods studentMethods = new StudentMethods(session);
		
		System.out.println("Welcome to Student Management Application:");
		
		while(true) {
			
			System.out.println("press 1 to Add Student:");
			System.out.println("press 2 to Update Student");
			System.out.println("press 3 to Delete Student");
			System.out.println("press 4 to Display All Student");
			System.out.println("press 5 to exit");
			
			System.out.println("Enter your choice");
			
			Scanner sc=new Scanner(System.in);
			int ch=sc.nextInt();
			if(ch==1) {
				System.out.println("Enter Student Name:");
				String sname=sc.next();
				System.out.println("Enter student Phone No:");
				String sphoneno=sc.next();
				System.out.println("Enter student City:");
				String scity=sc.next();
				StudentMethods.createStudent(sname,sphoneno,scity);	
			}
			else if(ch==2)
			{
			    System.out.println("Enter the Details you want to  be update:\n Press 1 To update the Student Name.\n press 2. To update the phone number.\n press 3. To update the city.");
				int update=sc.nextInt();
				switch(update) {
				case 1:
				{
					System.out.println("Enter the Student ID");
					int id=sc.nextInt();
					System.out.println("Enter the Student Name");
					String name=sc.next();
					StudentMethods.updateStudentName(id,name);
					break;
				}
				case 2:
				{
					System.out.println("Enter the Student ID");
					int id=sc.nextInt();
					System.out.println("Enter the Student phone no");
					String phoneno=sc.next();
					StudentMethods.updateStudentPhoneNo(id,phoneno);
					break;
				}
				case 3:
				{
					System.out.println("Enter the Student ID");
					int id=sc.nextInt();
					System.out.println("Enter the Student City");
					String city=sc.next();
					StudentMethods.updateStudentCity(id,city);
					break;
				}
					
				}		
			}
			else if(ch==3)
			{
				System.out.println("Enter STudent Id to delete");
				int id =sc.nextInt();
				StudentMethods.deleteStudent(id);
				
			}
			else if(ch==4)
			{
				StudentMethods.allStudents();
				
			}
			else if(ch==5)
			{
				System.out.println("Thanks for using");
				break;
			}
			}
		session.close();
		factory.close();
		
}
}
