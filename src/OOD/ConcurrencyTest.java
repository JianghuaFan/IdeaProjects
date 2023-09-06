package OOD;
public class ConcurrencyTest {
    class HelloClient implements Runnable{

        @Override
        public void run() {
            System.out.println("Hello");
        }
    }
//    public void run(){
//        System.out.println("The thread is running...");
//    }
//    public void start(){
//        // when this method is called, the thread is ready for scheduling
//        run();
//    }

        private static int a = 0;
        private static boolean b = true;
        public static  void  update(){
            a = 10;
            b = false;
        }

    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run(){
                System.out.println("Hello1");
            }
        };
        t.run();
        t.start();
        try{
            t.sleep(1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        System.out.println("Hello2");
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello3");
        Thread t1 = new Thread(() -> update());
        Thread t2 = new Thread(() -> {
            if(b == false){
                System.out.println(a);
            }
        });
    }
}
