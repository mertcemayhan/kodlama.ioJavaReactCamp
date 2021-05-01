
public class Instructor extends User{
	private String lecture;
	private int numberOfLesson;
	
	public Instructor() {
		
	}
	
	
	public Instructor(String lecture, int numberOfLesson) {
		super();
		this.lecture = lecture;
		this.numberOfLesson = numberOfLesson;
	}

	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

	public int getNumberOfLesson() {
		return numberOfLesson;
	}

	public void setNumberOfLesson(int numberOfLesson) {
		this.numberOfLesson = numberOfLesson;
	}
	
	
}
