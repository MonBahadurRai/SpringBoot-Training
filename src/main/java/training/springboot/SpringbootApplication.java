package training.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import training.springboot.dao.StudentDao;
import training.springboot.entity.Student;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
//			createAndSaveStudent(studentDao);
//			read Student by
//			reaStudentById(studentDao);
//
//			readAllStudents(studentDao);

//			System.out.println(studentDao.getStudentByFirstName("PER"));
//			System.out.println(studentDao.getStudentByFirstName("PERMOSd"));
//
////			printing Each Student
//			studentDao.findAllStudents().forEach(System.out::println);
//


//			studentDao.findByLastName("DAVIL").forEach(System.out::println);
//			updateStudent(studentDao);
//			deleteStudent(studentDao);
//
//			studentDao.sortStudentBy(" id desc ").forEach(System.out::println);

			System.out.println("Deleting All the Student records..");
			int statusRow = studentDao.deleteAll();
			if (statusRow > 0) {
				System.out.println("Finished Deleting All the Student records");
			} else if (statusRow == 0) {
				System.out.println("Empty Record!!");
			} else {
				System.out.println("Failed to Delete All the Student records");
			}
		};
	}

	private void deleteStudent(StudentDao studentDao) {
		studentDao.delete(1);
	}

	private void updateStudent(StudentDao studentDao) {
		int studentId = 2;
//		Getting the
		System.out.println("Getting the student Id ");
		Student queredStudent = studentDao.findById(studentId);

//		Changing the Student Detail
		queredStudent.setLastName("JOSD");
		queredStudent.setFirstName("we");
		studentDao.update(queredStudent);


	}

	private void readAllStudents(StudentDao studentDao) {
		System.out.println("=== Students List =====================================================================");
		studentDao.studentsListResult().forEach(System.out::println);
		System.out.println("==========================================================================================");
	}


	//	createAndSaveStudent method
	private void createAndSaveStudent(StudentDao studentDao) {
		//create the student object
		System.out.println("Creating new Student");
//
		Student student = new Student("Paul", "Doe", "paul@luv2Code.com");
		//save the student object
		studentDao.save(student);
		//display id of the saved student object
		System.out.println("Saved Student Id :" + student.getId());
	}

	// read the student by Id
	private void reaStudentById(StudentDao studentDao) {
		System.out.println(studentDao.findById(2));
	}

}

