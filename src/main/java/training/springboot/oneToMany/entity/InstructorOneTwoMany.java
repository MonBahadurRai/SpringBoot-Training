package training.springboot.oneToMany.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class InstructorOneTwoMany {

    public InstructorOneTwoMany() {
    }

    public InstructorOneTwoMany(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instructorOneTwoMany",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<CourseOneTwoMany> cours;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetailOneTwoMany instructorDetailOneTwoMany;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetailOneTwoMany getInstructorDetail() {
        return instructorDetailOneTwoMany;
    }

    public void setInstructorDetail(InstructorDetailOneTwoMany instructorDetailOneTwoMany) {
        this.instructorDetailOneTwoMany = instructorDetailOneTwoMany;
    }

    public List<CourseOneTwoMany> getCourses() {
        return cours;
    }

    public void setCourses(List<CourseOneTwoMany> cours) {
        this.cours = cours;
    }


    public void add(CourseOneTwoMany courseOneTwoMany) {
        if (cours == null) {
            cours = new ArrayList<>();
        }
        cours.add(courseOneTwoMany);
        courseOneTwoMany.setInstructor(this);
    }

    @Override
    public String toString() {
        return "InstructorOneTwoMany{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetailOneTwoMany=" + instructorDetailOneTwoMany +
                '}';
    }
}

