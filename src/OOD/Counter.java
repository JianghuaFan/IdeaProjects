package OOD;

public class Counter {
    private int value;
    public Counter(int value){
        this.value = value;
    }
    public void increse(){
        synchronized(this){// operations in critical section
            value++;
        }
        System.out.println("hello, after increase value is :" + value);
    }
    public synchronized void decrese(){
        value--;
        System.out.println("hello after decrease value is :" + value);
    }
    public synchronized int  getCount(){
        return value;
    }

    public static void main(String[] args) {
        Counter c1 = new Counter(1);
        Counter c2 = new Counter(1);
        c1.increse();
        c1.increse();
        c1.decrese();
        System.out.println(c1.getCount());
        c2.increse();
    }
}
