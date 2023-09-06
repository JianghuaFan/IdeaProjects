package OOD;

public class Person {
	String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setName(String lastname,String firstname) {
    	this.name = lastname + " " + firstname;
    }
}
