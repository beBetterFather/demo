package thread.create;

public class ExtendThread extends Thread{

    @Override
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名为："+this.currentThread().getName());
    }

    public static void main(String[] args){
        ExtendThread extendThread = new ExtendThread();
        extendThread.start();
    }
}
