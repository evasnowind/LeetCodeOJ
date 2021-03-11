package solution.interview.print1_99_with_3_thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenglong.yu
 * created on 2021/3/11
 */
public class Solution {


    /**
     * 参见这个帖子
     *
     * https://www.cnblogs.com/infoflow/p/java-condition-execution-order.html
     * @param args
     */
    public static void main(String[] args) {

        int num = 5;
        ReentrantLock lock = new ReentrantLock();
        Condition[] conditions = new Condition[num];
        for (int i = 0; i < num; i++) {
            conditions[i] = lock.newCondition();
        }

        PrintNumberThread[] printNumberThreads = new PrintNumberThread[num];
        for (int i = 0; i < num; i++) {
            printNumberThreads[i] = new PrintNumberThread(i, lock, conditions);
        }

        for (int i = 0; i < num; i++) {
            printNumberThreads[i].start();
        }
    }


}

class PrintNumberThread extends Thread {

    private int id;
    private ReentrantLock lock;
    private static int seq;
    private Condition[] conditions;
    private static final int MAX_SEQ = 99;

    public PrintNumberThread(int id, ReentrantLock lock, Condition[] conditions) {
        this.id = id;
        this.lock = lock;
        this.conditions = conditions;
        this.setName("thread-" + id);
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while (seq >= 0 && seq <= MAX_SEQ) {
                //还没轮到自己，则唤醒下一个线程，当前线程继续沉睡
                while (seq % conditions.length != id) {
                    conditions[(id + 1) % conditions.length].signal();
                    conditions[id].await();
                }

                //打印当前数字
                System.out.println(this.getName() + " " + seq);
                //利用静态变量，实际上3个线程更新的都是同一个变量，用锁控制了下而已
                seq++;
                //唤醒下一个，当前沉睡
                conditions[(id + 1) % conditions.length].signal();
                conditions[id].await();
            }

            endOthers();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void endOthers() {
        lock.lock();
        try {
            conditions[(id + 1) % conditions.length].signal();
            conditions[(id + 2) % conditions.length].signal();
        } finally {
            lock.unlock();
        }

    }
}
