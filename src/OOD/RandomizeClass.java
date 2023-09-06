package OOD;

import java.util.*;

public class RandomizeClass {
    // HashMap : <key, index>  ArrayList: <Entry> Entry: key, value
    // get
    // remove
    // put
    private Map<Integer, Integer> indexMap ;
    private List<Entry> list;
    private Random ramdom;
    // constructor
    public RandomizeClass(){
        this.indexMap = new HashMap<>();
        this.list  = new ArrayList<>();
        this.ramdom = new Random();
    }

    public boolean insert(int key, int value){
        // corner case
        if(indexMap.containsKey(key)){
            return false;
        }
        Entry entry = new Entry(key,value);
        // part 1: map
        indexMap.put(key, list.size());
        // part 2: list
        list.add(entry);
        return true;
    }

    public boolean remove(int key){
        //corner case
        Integer index = indexMap.get(key);

        if(index == null){
            return false;
        }
        // part 1: map
        indexMap.remove(key);
        // part 2: list

        if(index != list.size() - 1){
            swap(list, index, list.size() - 1);
            indexMap.put(list.get(index).key, index);
        }
        list.remove(list.size() - 1);
        return true;
    }

    private void swap(List<Entry> list, int index, int i) {
        Entry temp = list.get(index);
        list.set(index, list.get(i));
        list.set(i, temp);
    }

    static class Entry{
        int key;
        int value;
        public Entry(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public Integer getRandom(){
        // check
        if(list == null){
            return null;
        }
        int randomIndex = ramdom.nextInt(list.size());
        return list.get(randomIndex).key;
    }

    public static void main(String[] args) {
        RandomizeClass randomizeClass = new RandomizeClass();
        randomizeClass.insert(1,1);
        randomizeClass.insert(2,2);
        randomizeClass.insert(3,3);
        randomizeClass.insert(4,4);
        randomizeClass.insert(5,5);
        randomizeClass.insert(6,6);
        System.out.println(randomizeClass.indexMap);
        System.out.println(Arrays.toString(randomizeClass.list.toArray()));
        randomizeClass.remove(3);
        System.out.println(randomizeClass.indexMap);
        System.out.println(randomizeClass.getRandom());
    }
}
