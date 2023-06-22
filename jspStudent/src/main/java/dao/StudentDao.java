package dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Student;

public class StudentDao {

	public EntityManager geEntityManager() {
		return Persistence.createEntityManagerFactory("shubham").createEntityManager();

	}

	public Student saveStudent(Student student) {
		EntityManager manager = geEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(student);
		transaction.commit();
		return student;
	}

	public List<Student> getAllStudent() {
		EntityManager manager = geEntityManager();
		Query query = manager.createQuery("select a from Student a");

		List<Student> list = query.getResultList();

		return list;

	}

	public Student getStudentByEmail(String email) {
		EntityManager manager = geEntityManager();
		Query query = manager.createQuery("select a from Student a where a.studentEmail=?1");
		//this (studentEmail) is same as your databse column name 
		query.setParameter(1, email);
		Student student = (Student) query.getSingleResult();
		return student;
	}

	public void deleteStudentById(int id) {
		EntityManager manager = geEntityManager();
		Student student = manager.find(Student.class, id);
		if (student != null) {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(student);
			transaction.commit();
			// also we can return to chck null but need because already we check
			
		}
		
	}
	public Student updateStudent(int id , Student student)
	{
		EntityManager manager = geEntityManager();
		Student student2 = manager.find(Student.class, id);
		if (student != null) {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
		//	student.setStudentId(id);
			manager.merge(student);
			transaction.commit();
			return student;
		}
		return null;
		
	}

	public Student getstudentById(int id) {
		EntityManager manager=geEntityManager();
		Student student =manager.find(Student.class, id);
		return student;
	}

}
