package BinarySearch;

public class FindSmallestLetterGreaterThanTarget744 {
	//For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
//	Input: letters = ["c","f","j"], target = "a"
//			Output: "c"
	public static char nextGreatestLetter(char[] letters, char target) {
        if(target >= letters[letters.length - 1])
            return letters[0];
        int left = 0, right = letters.length -1;
        while(left < right){
            int mid = left + (right - left)/2;
            if (letters[mid] <= target)
                left = mid + 1;
            else right = mid; 
        }
        
        return letters[left];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] letters = new char[]{'c','f','j','k'};
		char target = 'j';
		System.out.print(nextGreatestLetter(letters,target));
	}

}
