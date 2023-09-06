package OOD;

public class Country {
	
	    String name;
	    void value() {
	       name = "China";
	    }
	
	  
	class City extends Country {
	    String name;
	    void value() {
	    name = "Shanghai";
	    super.value();      //调用父类的方法
	    System.out.println(name);
	    System.out.println(super.name);
	    }
	
	    
}
	public static void main(String[] args) {
	       Country c = new Country();
	       City c1 = c.new City();
	       c.value();
	       }

}