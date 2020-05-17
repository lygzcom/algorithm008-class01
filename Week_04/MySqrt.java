package algorithmtraining.fourthweek;

/**
 * 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class MySqrt {
    public static void main(String... ars) {
        System.out.println(Math.sqrt(2147483647));
        System.out.println(mySqrt1(2147483647));

    }

    //超时了且溢出了
    public static int mySqrt(int x) {
        if (x < 2) return x;
        int i = 1;
        while (i <= x / 2) {
            long t1 = i * i;
            long t2 = (i + 1) * (i + 1);
            if (t1 == x || (t1 < x && t2 > x)) {
                return i;
            }
            i++;
        }
        return 0;
    }

    public static int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        long left = 1;
        long right = x / 2;
        while (left + 1 < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            long mid = left + (right - left) / 2;
            // long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    //采用二分法 和除法
    public static int mySqrt2(int x) {
        if (x < 2) return x;
        int left = 1;
        int right = x;
        //加一跳出死循环
        /*默认情况下中位数通常省略小数部分 数据偏左 当接近结果时left+1==right
         *  t = x / mid=》 mid偏小导致t偏大=>更新左边界 mid一直是左边界
         * */
        while (left + 1 < right) {
            // int mid = left + ((right - left) / 2); //移位运算效率更高
            int mid = left + ((right - left) >> 1);
            int t = x / mid;
            if (mid == t) {
                return mid;
            } else if (mid > t) {
                right = mid;
            } else {
                left = mid;
            }

        }
        return right > x / right ? left : right;
    }
}
