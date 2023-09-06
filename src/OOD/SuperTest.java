package OOD;

public class SuperTest {

	class Country {
	    String name;
	    void value() {
	       name = "China";
	    }
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
	
	class Town extends Country{
//		@Override
		void value() {
			name = "Chanshiling";
		}
		
	}
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
       SuperTest s = new SuperTest();
       Country c = s.new Country();
       City city = s.new City();
//       System.out.print(city);
       SuperTest a = new SuperTest();;

       Person p = new Person();
       System.out.print(p.name);
       
       }

}
