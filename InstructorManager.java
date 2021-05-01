
public class InstructorManager extends UserManager{
	public void login(User user) {
		System.out.println(user.getFirstName()+user.getLastName()+ "baþarýlý bir þekilde eðitmen statüsünde giriþ yaptýnýz.");
	}
	
	public void logout(User user) {
		System.out.println(user.getFirstName()+user.getLastName()+ "baþarýlý bir þekilde eðitmen statüsünde çýkýþ yaptýnýz.");
	}
	
	public void availableCourseHours(Instructor instructor) {
		System.out.println(instructor.getNumberOfLesson() +" saat ders vereceksiniz.");
	}
}
