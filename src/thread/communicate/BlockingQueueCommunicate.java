package thread.communicate;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueCommunicate {

    private static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    try {
                        Thread.sleep(1000);
                        int r = new Random().nextInt(1000);
                        System.out.println("入队列: "+r);
                        queue.put(r);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    try {
                        Thread.sleep(1000);
                        System.out.println("出队列: "+queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
