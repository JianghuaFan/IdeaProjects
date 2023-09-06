package helloworld;

import java.util.Random;

public class RandomNumberWithinRange {
	public static int random(int a, int b) {
		
        Random rand = new Random();
        
//        System.out.println(rand.nextBoolean());
//        System.out.println(rand.nextInt());
//        System.out.println(rand.nextDouble());
//        System.out.println(rand.nextFloat());
        
        int d = rand.nextInt(b - a + 1) + a;
        return d;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		int b = 4;
		System.out.println(random(a,b));
		Random ran = new Random();
		//设置种子后可以重复生成一样的随机数
//		ran.setSeed(2);
		int c = ran.nextInt();
		int d = ran.nextInt();
		// c and d don't have seed, everytime they will be different
		System.out.println("c: " + c);
		System.out.println("d: " + d);		
		// new Random（longSeed）也是设置种子可以重复产生一样的伪随机数
		// e has a seed, it will create a pseudorandom number which means it will be same 
		int e = new Random(2).nextInt(20);
		System.out.println("e: " + e);
		int i = (int)Math.random()*3+1;
		System.out.println("i: " + i);

	}

}
