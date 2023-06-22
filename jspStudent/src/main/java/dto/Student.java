package dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int studentId;
	private String studentname;
	private String studentEmail;
	private String studentPassword;
	private String studentAddress;
	private double fees;
	private long phone;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentname=" + studentname + ", studentEmail=" + studentEmail
				+ ", studentPassword=" + studentPassword + ", studentAddress=" + studentAddress + ", fees=" + fees
				+ ", phone=" + phone + ", getStudentId()=" + getStudentId() + ", getStudentname()=" + getStudentname()
				+ ", getStudentEmail()=" + getStudentEmail() + ", getStudentPassword()=" + getStudentPassword()
				+ ", getStudentAddress()=" + getStudentAddress() + ", getFees()=" + getFees() + ", getPhone()="
				+ getPhone() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public Student(int studentId, String studentname, String studentEmail, String studentPassword,
			String studentAddress, double fees, long phone) {
		super();
		this.studentId = studentId;
		this.studentname = studentname;
		this.studentEmail = studentEmail;
		this.studentPassword = studentPassword;
		this.studentAddress = studentAddress;
		this.fees = fees;
		this.phone = phone;
	}
	public Student() {
		super();
	}
	
}
