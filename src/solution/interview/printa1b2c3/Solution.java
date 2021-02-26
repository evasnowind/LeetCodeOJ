package solution.interview.printa1b2c3;

/**
 * @author chenglong.yu
 * created on 2021/2/24
 */
public class Solution {

    public static void main(String[] args) {

        char[] ch1 = new char[]{'a', 'b', 'c'};
        char[] ch2 = new char[]{'1', '2', '3'};

        Object obj = new Object();

        Thread t1 = new Thread(() -> {

            for (char ch : ch1) {
                synchronized (obj) {
                    System.out.println(ch);

                    try {
                        obj.notifyAll();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, "ch thread");

        Thread t2 = new Thread(() -> {
            for (char ch : ch2) {
                synchronized (obj) {
                    System.out.println(ch);
                    try {
                        obj.notifyAll();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "int thread");

        t1.start();
        t2.start();
    }

}
