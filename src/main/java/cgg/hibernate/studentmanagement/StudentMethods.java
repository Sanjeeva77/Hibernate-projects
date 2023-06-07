package cgg.hibernate.studentmanagement;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import cgginterns.hibernate.Student;

public class StudentMethods {
	
	private static Session session;
	
	public StudentMethods(Session session) {
        this.session = session;
    }

	public static void createStudent(String sname, String sphoneno, String scity) {
		
		 Transaction transaction = session.beginTransaction();
	        StudentManage student = new StudentManage(sname,sphoneno,scity);
	        session.save(student);
	        transaction.commit();
	        System.out.println("Student created and saved: " + student.getName() +":"+ student.getPhoneno()+":"+student.getCity());
		
		
	}

	public static void updateStudentName(int id, String name) {
		Transaction transaction = session.beginTransaction();
        StudentManage student = session.get(StudentManage.class, id);
        student.setName(name);
        session.update(student);
        transaction.commit();
        System.out.println("Student name updated: " + student.getName() +":"+ student.getPhoneno()+":"+student.getCity());
		
	}

	public static void updateStudentPhoneNo(int id, String phoneno) {
		Transaction transaction = session.beginTransaction();
        StudentManage student = session.get(StudentManage.class, id);
        student.setPhoneno(phoneno);
        session.update(student);
        transaction.commit();
        System.out.println("Student phoneno updated: " + student.getName() +":"+ student.getPhoneno()+":"+student.getCity());
		
	}

	public static void updateStudentCity(int id, String city) {
		Transaction transaction = session.beginTransaction();
        StudentManage student = session.get(StudentManage.class, id);
        student.setCity(city);
        session.update(student);
        transaction.commit();
        System.out.println("Student city updated: " + student.getName() +":"+ student.getPhoneno()+":"+student.getCity());
		
	}

	public static void deleteStudent(int id) {
		
		session.beginTransaction();
		
		StudentManage student = session.get(StudentManage.class, id);
		if (student != null) {
            session.delete(student);
            session.getTransaction().commit();
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
		
	}

	public static void allStudents() {
		 String query = "FROM StudentManage";
		 Query q= session.createQuery(query);
		 
		 List<StudentManage> list = q.list();
		 for(StudentManage student:list) {
			 System.out.println(student.getName()+":"+student.getPhoneno()+":"+student.getCity());
		 }
		 
		
	}
	
	

}
