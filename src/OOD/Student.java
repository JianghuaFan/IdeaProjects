package OOD;


public class Student {
	String name;
	int age;
	int ID;
	String address;
	int phoneNumber;
	static int score;
	static int StudentNumber;
	


	
	public Student(String name) {
		this.name = name;

	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	


	
	public static double aveScore() {
		return score / StudentNumber;
	}
	
	public void visit() {
		Student b = new Student("Bob");
		b.aveScore();
		Student.aveScore();
	}
	
	

}
