package TestPackage;

public class EnumTest {
	public enum RainbowColor {
		RED, ORANGE, YELLO, GREEN, CYAN, BLUE, PURPLE;				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RainbowColor color = RainbowColor.BLUE;
		for(RainbowColor c : RainbowColor.values()) {
			System.out.println(c);
			System.out.println(c.ordinal());			
		}
		System.out.println(RainbowColor.valueOf("RED"));
//		System.out.println(RainbowColor.valueOf("red"));//java.lang.IllegalArgumentException
		System.out.println(RainbowColor.valueOf("RED") == RainbowColor.RED);
	}

}
