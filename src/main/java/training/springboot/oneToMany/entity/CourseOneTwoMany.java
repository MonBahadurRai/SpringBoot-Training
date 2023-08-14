package training.springboot.oneToMany.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class CourseOneTwoMany {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name ="title")
    private String title;


    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private InstructorOneTwoMany instructorOneTwoMany;


    public CourseOneTwoMany() {

    }

    public InstructorOneTwoMany getInstructor() {
        return instructorOneTwoMany;
    }

    public void setInstructor(InstructorOneTwoMany instructorOneTwoMany) {
        this.instructorOneTwoMany = instructorOneTwoMany;
    }

    public CourseOneTwoMany(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CourseOneTwoMany{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructorOneTwoMany=" + instructorOneTwoMany +
                '}';
    }
}
