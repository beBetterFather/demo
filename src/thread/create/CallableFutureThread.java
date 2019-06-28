package thread.create;

import java.util.concurrent.*;

public class CallableFutureThread implements Callable {

    @Override
    public Object call() throws Exception {
        return Thread.currentThread().getName()+"" +
                " Red star over china";
    }

    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool();
        Future future = service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名为："+Thread.currentThread().getName());
            }
        });
        //Future
        Future f = service.submit(new CallableFutureThread());
        try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //FutureTask
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallableFutureThread());
        service.submit(futureTask);
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
