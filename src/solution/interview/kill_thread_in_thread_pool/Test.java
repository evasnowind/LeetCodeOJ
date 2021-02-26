package solution.interview.kill_thread_in_thread_pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author chenglong.yu
 * created on 2021/2/25
 */
public class Test {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);


        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("thread id=" + Thread.currentThread() + "task start......");
                TimeUnit.SECONDS.sleep(2);
                long i = 0;
                while(true) {
                    i++;
                    if (i > 10000000000L) {
                        System.out.println("计数结束！");
                        break;
                    }
                }

                return "task finish!";
            }
        });

        executorService.submit(futureTask);
        try {
            TimeUnit.SECONDS.sleep(1);

            boolean flag = futureTask.cancel(true);
            System.out.println("flag=" + flag);
            System.out.println("任务被终止！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
