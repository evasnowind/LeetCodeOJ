package solution.interview.print1_99_with_3_thread;

/**
 * @author chenglong.yu
 * created on 2021/3/11
 */
public class Solution2 {


    public static void main(String[] args) {
        Object lock1 = new Object(), lock2 = new Object(), lock3 = new Object();
        ThreadPrinter a = new ThreadPrinter(1, lock3, lock1);
        ThreadPrinter b = new ThreadPrinter(2, lock1, lock2);
        ThreadPrinter c = new ThreadPrinter(3, lock2, lock3);


        a.start();
        b.start();
        c.start();
    }
}

class ThreadPrinter extends Thread {
    private Object prev;
    private Object cur;
    public static int count;
    public static int MAX_CNT = 99;


    public ThreadPrinter(int id, Object prev, Object cur) {
        this.prev = prev;
        this.cur = cur;
        this.setName("thread-" + id);
    }


    @Override
    public void run() {
        while (count < MAX_CNT) {
        /*
        保证上一次执行完之后，才执行本次打印
         */
            synchronized (prev) {
            /*
            拿到当前的锁
             */
                synchronized (cur) {
                    System.out.println(this.getName() + " " + count);
                    count++;
                    cur.notifyAll();
                }

                try {
                    // 立即释放 prev锁，当前线程休眠，等待唤醒
                    prev.wait();
                    /**
                     * JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。
                     */
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.exit(0);

    }

}
