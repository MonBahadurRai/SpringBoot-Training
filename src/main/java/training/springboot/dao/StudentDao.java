package training.springboot.dao;


import training.springboot.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);

    Student findById(int id);

    List<Student> studentsListResult();

    Student getStudentByFirstName(String firstName);

    List<Student> findAllStudents();

    List<Student> sortStudentBy(String queryField);

    List<Student> findByLastName(String lastName);

    void update(Student student);


    void delete(int id);


    int deleteAll();

}
