package helloworld;

public class Main {
	/**
	 * @param arr 排列数组
	 * @param index 前缀的位置（数组下标）
	 * @author jiang
	 *
	 */
	public static void fun1(char arr[], int index) {
		if(index == arr.length - 1) {
			System.out.println(String.valueOf(arr));
		}
		for(int i = index; i < arr.length; i++) {
			char t = arr[index];
			arr[index] = arr[i] ;
			arr[i] = t;
			fun1(arr, index + 1);
			{
				t = arr[index];
				arr[index] = arr[i] ;
				arr[i] = t;
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "123";
		fun1(str.toCharArray(),0);
	}

}
