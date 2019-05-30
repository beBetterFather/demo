package thread.control;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JoinThread{

    private static int i = 0;

    //有返回值得线程
    public static class CallableThread implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            return i+1;
        }
    }

    public static void main(String[] args){
        CallableThread callableThread = new CallableThread();
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i=0; i<100; i++){
        }
    }


}
