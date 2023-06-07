package cgg.hibernate.studentmanagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentManage {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentid;
	private String name;
	private String phoneno;
	private String city;
	public StudentManage(String name, String phoneno, String city) {
		super();
		this.name = name;
		this.phoneno = phoneno;
		this.city = city;
	}
	public StudentManage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	

}
