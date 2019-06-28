package thread.control.relation;

public class Count implements Runnable {

    private static Integer sCount = new Integer(0);

    public Integer getCount(){
        return sCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (sCount) {
                System.out.println(Thread.currentThread().getName()+" sCount++");
                sCount++;
            }
        }
    }

}
