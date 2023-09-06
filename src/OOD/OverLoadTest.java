package OOD;

public class OverLoadTest {
	static int a;
    static int b;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Person ming = new Person();
	        Person hong = new Person();
	        
	        ming.setName("Xiao Ming");
	        // TODO: 给Person增加重载方法setName(String, String):
	        hong.setName("Xiao", "Hong");
	        System.out.println(ming.getName());
	        System.out.println(hong.getName());
	        String s = "Test string";
	        int n1 = s.indexOf('t');
	        int n2 = s.indexOf("st");
	        int n3 = s.indexOf("st", 0);
	        int n4 = s.indexOf("st", 4);
	       
	        System.out.println(n1);
	        System.out.println(n2);
	        System.out.println(n3);
	        System.out.println(n3);
		}
	}


