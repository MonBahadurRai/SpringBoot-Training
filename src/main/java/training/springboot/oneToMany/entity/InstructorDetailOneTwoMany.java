package training.springboot.oneToMany.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetailOneTwoMany {


    public InstructorDetailOneTwoMany() {
    }

    public InstructorDetailOneTwoMany(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;


    @OneToOne(mappedBy = "instructorDetailOneTwoMany", cascade = {CascadeType.ALL, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    private InstructorOneTwoMany instructorOneTwoMany;


    public InstructorOneTwoMany getInstructor() {
        return instructorOneTwoMany;
    }

    public void setInstructor(InstructorOneTwoMany instructorOneTwoMany) {
        this.instructorOneTwoMany = instructorOneTwoMany;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetailOneTwoMany{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
