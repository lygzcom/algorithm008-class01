package algorithmtraining.thirdweek;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/submissions/
 */
public class ClimbStairs {
    //死递归 向下
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }

    }

    //列举出所有可能情况  向上递归
    public static int climbStairs(int i, int n) {
        if (i > n) {//超过了退出
            return 0;
        }
        if (i == n) {//达到目标 返回
            return 1;
        }
        //累计所有可能的情况  一次走一步 一次走两步
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }

    //利用缓存加速
    public static int climbStairs1(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }

    public static int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

    //f(n)=f(n-1)+f(n-2)  利用迭代
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = i1 + i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }

    //动态规划  dp[i] = dp[i - 1] + dp[i - 2];
    public int climbStairs4(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
