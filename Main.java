
public class Main {

	public static void main(String[] args) {
		
		Student student = new Student();
		student.setId(1);
		student.setFirstName("Mert");
		student.setLastName("Ayhan");
		student.setGraduateStatus("Undergraduate");
		
		Instructor instructor = new Instructor();
		instructor.setId(1);
		instructor.setFirstName("Engin");
		instructor.setLastName("Demirog");
		instructor.setLecture("Java");
		instructor.setNumberOfLesson(10);
		
		StudentManager studentManager = new StudentManager();
		studentManager.addEducationLevel(student);
		
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.availableCourseHours(instructor);
		

	}

}
