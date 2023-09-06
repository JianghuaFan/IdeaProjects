package OOD;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ProducerConsumer {
    class Producer implements Runnable{
        Q q;
        public Producer(Q q){
            super();
            this.q = q;
        }

        @Override
        public void run() {
            q.put(1);
        }
    }
    class Consumer implements Runnable{
        Q q;
        public Consumer(Q q){
            super();
            this.q = q;
        }
        @Override
        public void run(){
            q.take();
        }
    }
    class Q{
        private Queue<Integer> q;
        private final int limit;
        public Q(int limit){
            this.limit = limit;
            this.q = new ArrayDeque<Integer>();
        }
        public synchronized void put(Integer ele){
            while(q.size() == limit){
                try{
                    wait();// this.wait()
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            // q.size() != limit 自己没被卡主，consumer被卡住了
            if(q.size() == 0){ // pool 空的，通知consumer 可以来拿东西了，因为自己马上要放。meaning all the put thread have been blocked
                notifyAll();
            }
            System.out.println("ele: " + ele);
            q.offer(ele);
        }

        public synchronized Integer take(){
            while(q.size() == 0){
                try{
                    wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            // q.size() != 0
            if(q.size() == limit){
                notifyAll();
            }
            System.out.println("q.peek: " + q.peek());
            return q.poll();
        }
    }
    public static void main(String[] args) {
        ProducerConsumer p = new ProducerConsumer();
        Q q = p.new Q(2);
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            threads.add(new Thread(p.new Producer(q)));
        }
        for(int i = 0; i < 5; i++){
            threads.add(new Thread(p.new Consumer(q)));
        }
        for(Thread t : threads){
            t.start();
        }
    }

}
