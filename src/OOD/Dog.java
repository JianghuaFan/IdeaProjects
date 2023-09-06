package OOD;

public class Dog implements Animal {
	int age;
	public Dog(int age) {
		this.age = age;
	}
	public Dog() {
		super();
	}
	public int getAge(int age) {
		System.out.print("age: " + age);
		return age;
	}

	@Override
	public void woo() {
		// TODO Auto-generated method stub
		System.out.print("Dog can bark.");
		
	}
	public static void main(String[] args) {
		Dog dog = new Dog(3);
		dog.getAge(3);
		int[] array = new int[2];
	
	}

}
