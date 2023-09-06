package BinarySearch;

public class Dictionary1{

	int[] array = {1,2,3,4,5,6,7,8,9,10};
	int index;
	public Dictionary1( int[] array){
		this.array = array;		
	}
	public Integer get(int index) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == array[index]) {
				return array[i];
			}
		}
		return null;
	}
}