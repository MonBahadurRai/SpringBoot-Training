package training.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import training.springboot.OneToOne.dao.AppDao;
import training.springboot.OneToOne.entity.Instructor;
import training.springboot.OneToOne.entity.InstructorDetail;
import training.springboot.oneToMany.entity.CourseOneTwoMany;
import training.springboot.oneToMany.entity.InstructorDetailOneTwoMany;
import training.springboot.oneToMany.entity.InstructorOneTwoMany;

import java.util.ArrayList;
import java.util.List;
//import training.springboot.oneToMany.entity.CourseOneTwoMany;
//import training.springboot.oneToMany.entity.InstructorOneTwoMany;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
//			createInstructor(appDao);
//			findInstructors(appDao);

//			appDao.deleteInstructor(4);


//			findInstructorsDetail(appDao);
//
//			appDao.deleteInstructionDetail(4);
//			findInstructorsDetail(appDao);


//			createInstructorWithCourses(appDao);

			InstructorOneTwoMany instructorOneTwoMany = appDao.findInstructorById(1);
			System.out.println(instructorOneTwoMany);

//			findInstructorsWithCourse(appDao);


		};


	}

	private void findInstructorsWithCourse(AppDao appDao) {
		int theId = 1;
		System.out.println("Finding instructor id :" + theId);
		InstructorOneTwoMany instructorOneTwoMany = appDao.findInstructorById(theId);

		appDao.findCoursesByInstructorId(theId).forEach(System.out::println);

		System.out.println(appDao.findInstructorByIdJoinFetch(1));
		System.out.println(instructorOneTwoMany.getInstructorDetail());
	}

	private void createInstructorWithCourses(AppDao appDao) {

		InstructorOneTwoMany tempInstructor = new InstructorOneTwoMany("Karma", "Tshering", "karma@gmail.com");
		InstructorDetailOneTwoMany tempInstructorDetail = new InstructorDetailOneTwoMany("youtube@karma", "Talkiing");
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		List<CourseOneTwoMany> courses = new ArrayList<>();
		courses.add(new CourseOneTwoMany("SPRING Core"));
		courses.add(new CourseOneTwoMany("SPRING SPRING JPA"));
		courses.add(new CourseOneTwoMany("SPRING MVC"));

		courses.forEach(tempInstructor::add);

		appDao.save(tempInstructor);


//		findInstructorsWithCourse(appDao);
//		 InstructorOneTwoMany instructorOneTwoMany().

//		appDao.update();
	}

	private void findInstructorsDetail(AppDao appDao) {
		InstructorDetail instructorDetail = appDao.instructorDetail(4);
		System.out.println(instructorDetail);
		if (instructorDetail != null) {
			System.out.println(instructorDetail.getInstructor());
		}

	}


	private void findInstructors(AppDao appDao) {
		System.out.println(appDao.findInstructor(3));
	}

	private void createInstructor(AppDao appDao) {
		Instructor tempInstructor = new Instructor("Karma", "Tshering", "karma@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("youtube@karma", "Talkiing");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		appDao.save(tempInstructor);
	}

}

