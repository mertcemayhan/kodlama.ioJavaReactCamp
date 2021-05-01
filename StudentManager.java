
public class StudentManager extends UserManager{
	public void login(User user) {
		System.out.println(user.getFirstName()+user.getLastName()+ "ba�ar�l� bir �ekilde giri� yapt�n�z.");
	}
	
	public void logout(User user) {
		System.out.println(user.getFirstName()+user.getLastName()+ "ba�ar�l� bir �ekilde ��k�� yapt�n�z.");
	}
	
	public void addSchool(Student student) {
		System.out.println(student.getSchoolName() +" okulu profilinize eklendi.");
	}
	
	public void addEducationLevel(Student student) {
		System.out.println("E�itim durumunuz "+ student.getGraduateStatus() +" olarak kay�t edilmi�tir.");
	}
}
