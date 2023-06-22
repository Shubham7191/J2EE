package studentManagementSystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import studentManagementSystem.dto.Student;

public class StudentDao {
	
	
	public Student saveStudentDao(Student student)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("shubham");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(student);
		transaction.commit();
		System.out.println("saved");
		return student;
	}
	
	
	public void loginStudent(String email ,String passwor)
	{
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("shubham");
	EntityManager manager = factory.createEntityManager();
Query query=manager.createQuery("select a from Student a where a.email=?1");
	
query.setParameter(1, email);



Student studdnt = (Student) query .getSingleResult();

if (studdnt != null) {
	
	boolean values = studdnt.getPassword().equals(passwor);
	if (values)
	{
		System.out.println("login sucessfullly");
	}
	else
	{
		System.out.println("longin not sucessfully");
	}
	
}
	
	
	
	
	
	}


	public Student deleteStudent(int id) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("shubham");
		EntityManager manager = factory.createEntityManager();
		Student student = manager.find(Student.class,id);
		
		if (student != null) {
				 EntityTransaction transaction = manager.getTransaction();
				 transaction.begin();
				 manager.remove(student);
				 transaction.commit();
					return student;
			
		}
		return null;

		
	}


	public Student updateStudent(int id,  String Sname) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("shubham");
		EntityManager manager = factory.createEntityManager();
		Student student = manager.find(Student.class,id);
		if (student != null) {
			 EntityTransaction transaction = manager.getTransaction();
			 
			 student.setName(Sname);
			 
			 transaction.begin();
			 manager.merge(student);
			 transaction.commit();
			return student;
		
	}
		
		return null;
		
	}


	public Student login2Student(String gmail, String pass) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("shubham");
		EntityManager manager = factory.createEntityManager();
	Query query =	manager.createQuery("select a from Student a ");
	 List<Student> list =query.getResultList();
	 
	 
	 for(Student student:list)
	 {
		if (student.getEmail(). equals( gmail)) 
		{
			Query query2=	manager.createQuery("select a from Student a where a.email=?1");
			query2.setParameter(1,gmail);
			Student dbcard =(Student) query2.getSingleResult();
			 return dbcard;
			
	     }
		else {
			return null;
		}
	 }
		
		return null;
		
	
}


	


	public Student selectStudent(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("shubham");
		EntityManager manager = factory.createEntityManager();
		Student student =manager.find(Student.class, id);
		return student ;
	}
	
	public java.util.List<Student> getAllStudents()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("shubham");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select a from Student a ");
		List<Student> list = query.getResultList();
		return list;
	}


	public Student getStudentByEmail(String email) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("shubham");
	    EntityManager manager = factory.createEntityManager();
	    Query query = manager.createQuery("SELECT s FROM Student s WHERE s.email = ?1");
	    query.setParameter(1, email);
	    Student student = (Student) query.getSingleResult();
	    return student;
	}


	

}
