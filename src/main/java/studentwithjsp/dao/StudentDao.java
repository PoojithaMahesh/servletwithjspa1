package studentwithjsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import studentwithjsp.dto.Student;

public class StudentDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("pooji").createEntityManager();
	}

	public Student signupStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(student);

		entityTransaction.commit();
		return student;
	}

	public List<Student> getAllStudents() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("Select s from Student s");
		return query.getResultList();
	}

	public Student getStudentByEmail(String email) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("Select s from Student s where s.email=?1");
		query.setParameter(1, email);
		Student student = (Student) query.getSingleResult();
		return student;
	}

	public void deleteStudentById(int id) {
		EntityManager entityManager = getEntityManager();
		Student student = entityManager.find(Student.class, id);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
	}

	public Student findstudentById(int id) {
		EntityManager entityManager = getEntityManager();
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	public void updateStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.merge(student);

		entityTransaction.commit();
		
		
	}

}
