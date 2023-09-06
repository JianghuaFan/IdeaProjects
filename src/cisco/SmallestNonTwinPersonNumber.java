package cisco;
// input: 7
//        1 1 2 3 3 4 4
// output: 2
public class SmallestNonTwinPersonNumber {
    public int nonTwinSmallestPerson(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }
        for(int i = 0; i < array.length - 1; i += 2){
            if(array[i] != array[i + 1]){
                return array[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SmallestNonTwinPersonNumber smallestNonTwinPersonNumber = new SmallestNonTwinPersonNumber();
        int[] array = {1,1,2,3,3,4,4};
        System.out.println(smallestNonTwinPersonNumber.nonTwinSmallestPerson(array));
    }
}
