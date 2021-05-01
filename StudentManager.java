
public class StudentManager extends UserManager{
	public void login(User user) {
		System.out.println(user.getFirstName()+user.getLastName()+ "baþarýlý bir þekilde giriþ yaptýnýz.");
	}
	
	public void logout(User user) {
		System.out.println(user.getFirstName()+user.getLastName()+ "baþarýlý bir þekilde çýkýþ yaptýnýz.");
	}
	
	public void addSchool(Student student) {
		System.out.println(student.getSchoolName() +" okulu profilinize eklendi.");
	}
	
	public void addEducationLevel(Student student) {
		System.out.println("Eðitim durumunuz "+ student.getGraduateStatus() +" olarak kayýt edilmiþtir.");
	}
}
