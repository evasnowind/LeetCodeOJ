package solution.interview.classstatic_load_sequence;

/**
 * @author chenglong.yu
 * created on 2021/2/26
 */
public class Test {


    static Test Test = new Test();

    static int amount = 112;

    int price = 110;

    static {
        System.out.println("静态代码块");
        System.out.println("amount=" + amount);
    }

    {
        System.out.println("普通代码块");
        System.out.println("price=" + price + ",amount=" + amount);
    }

    Test() {
        System.out.println("构造方法");
        System.out.println("price=" + price + ",amount=" + amount);
    }

    public static void main(String[] args) {
        staticFunction();
    }

    public static void staticFunction() {
        System.out.println("静态方法");
    }
}
