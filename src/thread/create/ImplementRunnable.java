package thread.create;

public class ImplementRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("线程名称："+Thread.currentThread().getName());
    }

    public static void main(String[] args){
        ImplementRunnable runnable = new ImplementRunnable();
        new Thread(runnable).start();
    }
}
