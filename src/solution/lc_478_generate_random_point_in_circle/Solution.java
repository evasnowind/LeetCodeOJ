package solution.oj_478_generate_random_point_in_circle;

/**
 * @author chenglong.yu@100credit.com
 * created on 2019/8/24
 */
public class Solution {

    double radius, x_center, y_center;

    /**
     * 参考
     * https://leetcode.com/problems/generate-random-point-in-a-circle/discuss/154037/Polar-Coordinates-10-lines
     *
     * 我自己的思路：
     * 先选定一个x in [0,radius]
     * 然后根据勾股定理，算出y坐标可能的区间（是一个等腰三角形），然后y在该区间取值即可。但上面链接给出的方案更加精巧。
     * 即：先算出一个随机的半径，然后根据半径得出角度值，然后用cos sin算出x y
     *
     * @param radius
     * @param x_center
     * @param y_center
     */
    public Solution(double radius, double x_center, double y_center) {
        this.radius=radius;
        this.x_center=x_center;
        this.y_center=y_center;
    }

    public double[] randPoint() {
        double len= Math.sqrt(Math.random())*radius;
        double deg = Math.random() * Math.PI * 2;
        double x= x_center+len*Math.cos(deg);
        double y= y_center+len*Math.sin(deg);
        return new double[]{x,y};
    }
}
