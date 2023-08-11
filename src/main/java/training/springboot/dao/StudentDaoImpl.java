package training.springboot.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import training.springboot.entity.Student;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Transactional(readOnly = true)
    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Transactional
    @Override
    public List<Student> studentsListResult() {
        return entityManager.createQuery("from Student ", Student.class).getResultList();

    }

    @Transactional
    @Override
    public Student getStudentByFirstName(String firstName) {
        String query = "SELECT s FROM Student s WHERE s.firstName = :firstName";
        TypedQuery<Student> typedQuery = entityManager.createQuery(query, Student.class);
        typedQuery.setParameter("firstName", firstName);
        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException ex) {
            return null; // Handle the case where no student with the given first name is found
        }
    }

    @Transactional
    @Override
    public List<Student> findAllStudents() {
        //create query
//        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ", Student.class);
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by id asc ", Student.class);
        //return all result
        return theQuery.getResultList();
    }


    @Transactional
    @Override
    public List<Student> sortStudentBy(String queryField) {
        //return all result
        return entityManager.createQuery("FROM Student order by " + queryField, Student.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Student> findByLastName(String lastNameQuery) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:lastNameQuery", Student.class);
        theQuery.setParameter("lastNameQuery", lastNameQuery);
        return theQuery.getResultList();
    }

    @Transactional()
    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Transactional
    @Override
    public void delete(int id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        } else {
            System.out.println("Nothing to delete!");
        }
//
    }

    @Transactional
    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student ").executeUpdate();
    }

}
