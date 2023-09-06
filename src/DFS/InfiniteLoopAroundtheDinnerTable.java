package DFS;

public class InfiniteLoopAroundtheDinnerTable {
    public boolean infiniteLoop(String[] str){
        if(str == null || str.length == 0){
            return false;
        }
        return DFS(str, 1);
    }
    private boolean DFS(String[] str, int index){
        // base case: 遍历完所有名字， 并且最后一个和第一个可以接起来，返回true
        if(index == str.length){
            if(canConnect(str, index - 1, 0));
            return true;
        }
        // case 1:
        for(int i = index; i < str.length; i++){
            if(canConnect(str,index - 1, i)){
                swap(str, index, i);
                if(DFS(str, index + 1)){
                    return true;
                }
                swap(str, index, i);
            }
        }
        return false;
    }

    private void swap(String[] str, int left, int right) {
        String temp = str[left];
        str[left] = str[right];
        str[right] = temp;
    }

    private boolean canConnect(String[] str, int left, int right) {
        if(str[left].charAt(str[left].length() - 1) == str[right].charAt(0)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] str = {"ALICE", "CHARLES", "ERIC", "SOPHIA"};
        InfiniteLoopAroundtheDinnerTable infiniteLoopAroundtheDinnerTable = new InfiniteLoopAroundtheDinnerTable();
        System.out.println(infiniteLoopAroundtheDinnerTable.infiniteLoop(str));
    }
}
