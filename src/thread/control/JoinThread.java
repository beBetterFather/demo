package thread.control;

import thread.control.relation.Count;

public class JoinThread{

    public static void main(String[] args){
        Count count = new Count();
        Thread t1 = new Thread(count, "thread01");
        Thread t2 = new Thread(count, "thread02");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(count.getCount());
    }

}
