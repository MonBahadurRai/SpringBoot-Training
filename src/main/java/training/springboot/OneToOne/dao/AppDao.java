package training.springboot.OneToOne.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import training.springboot.OneToOne.entity.Instructor;
import training.springboot.OneToOne.entity.InstructorDetail;
import training.springboot.oneToMany.entity.CourseOneTwoMany;
import training.springboot.oneToMany.entity.InstructorOneTwoMany;

import java.util.List;

@Repository
public class AppDao {

    private final EntityManager entityManager;

    @Autowired
    public AppDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Transactional
    public void save(InstructorOneTwoMany instructor) {
        entityManager.persist(instructor);
    }

    @Transactional
    public Instructor findInstructor(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Transactional
    public void deleteInstructor(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        if (instructor != null) {
            entityManager.remove(entityManager.find(Instructor.class, id));
            System.out.println("Deletion Done!");
        } else {
            System.out.println("No instructor found at Id " + id);
        }
    }

    @Transactional
    public InstructorDetail instructorDetail(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Transactional
    public void deleteInstructionDetail(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        if (instructorDetail != null) {
            entityManager.remove(instructorDetail);
            System.out.println("Deletion Done!");
        } else {
            System.out.println("No instructor Detail found at Id " + id);
        }
    }


    public InstructorOneTwoMany findInstructorById(int theId) {
        return entityManager.find(InstructorOneTwoMany.class, theId);
    }

    public List<CourseOneTwoMany> findCoursesByInstructorId(int theId) {
        TypedQuery<CourseOneTwoMany> query = entityManager.createQuery("FROM CourseOneTwoMany where instructorOneTwoMany.id=:instructorId", CourseOneTwoMany.class);
        query.setParameter("instructorId", theId);
        return query.getResultList();
    }


    @Transactional
    public InstructorOneTwoMany findInstructorByIdJoinFetch(int theId) {
        TypedQuery<InstructorOneTwoMany> query = entityManager.createQuery("select i from InstructorOneTwoMany i join  fetch  i.cours where i.id=:data", InstructorOneTwoMany.class);
        query.setParameter("data", theId);
        return query.getSingleResult();
    }


    @Transactional
    public void update(InstructorOneTwoMany theInstructorOneTwoMany) {
        entityManager.merge(theInstructorOneTwoMany);
    }
}

