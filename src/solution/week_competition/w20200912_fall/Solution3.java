package solution.week_competition.w20200912_fall;

/**
 * @author chenglong.yu
 * created on 2020/9/12
 */
public class Solution3 {

    public static void main(String[] args) {
        int x = 1, y = 0;

        String st = "AB";
        char[] chs = st.toCharArray();
        for (char ch : chs) {
            if (ch == 'A') {
                x = 2 * x + y;
            } else if (ch == 'B') {
                y = 2 * y + x;
            }
        }

        System.out.println(x + y);
    }
}
