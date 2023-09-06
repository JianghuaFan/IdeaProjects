package OOD;

public class LombokTest {
	private String name;
	int age;	
	
	public LombokTest(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public int getAge() {
		return age;
	}

    public String getName() {
        return name;
    }  
    
    public void setName(String lastname,String firstname) {
    	this.name = lastname + " " + firstname;
    }
    
//    @Data lombok
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
