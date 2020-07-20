package solution.lc_504_base_7;

/**
 * @author chenglong.yu
 * created on 2019/6/23
 */
public class Solution {

    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        int base = 7;
        int a = Math.abs(num);
        int b = 0;
        StringBuilder builder = new StringBuilder();
        while (a != 0) {
            b = a % base;
            builder.insert(0, b);
            a = a / base;
        }
        if (num < 0) {
            builder.insert(0, '-');
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("res=" + convertToBase7(100));
        System.out.println("res=" + convertToBase7(1));
        System.out.println("res=" + convertToBase7(7));
        System.out.println("res=" + convertToBase7(0));
        System.out.println("res=" + convertToBase7(-21));
    }
}
