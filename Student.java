
public class Student extends User{
	private String schoolName;
	private String graduateStatus;
	
	public Student() {
		
	}
	
	
	public Student(String schoolName, String graduateStatus) {
		super();
		this.schoolName = schoolName;
		this.graduateStatus = graduateStatus;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getGraduateStatus() {
		return graduateStatus;
	}

	public void setGraduateStatus(String graduateStatus) {
		this.graduateStatus = graduateStatus;
	}
	
	
}
