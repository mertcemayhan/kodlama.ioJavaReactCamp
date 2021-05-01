
public class InstructorManager extends UserManager{
	public void login(User user) {
		System.out.println(user.getFirstName()+user.getLastName()+ "ba�ar�l� bir �ekilde e�itmen stat�s�nde giri� yapt�n�z.");
	}
	
	public void logout(User user) {
		System.out.println(user.getFirstName()+user.getLastName()+ "ba�ar�l� bir �ekilde e�itmen stat�s�nde ��k�� yapt�n�z.");
	}
	
	public void availableCourseHours(Instructor instructor) {
		System.out.println(instructor.getNumberOfLesson() +" saat ders vereceksiniz.");
	}
}
