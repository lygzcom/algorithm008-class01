package algorithmtraining.第九周;


public class 不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //dp表记录的是到i,j最多有几条路径
        int[][] dp = new int[m][n];
        int i = 0;
        //上边界在不遇到障碍物时只有唯一路径
        while (i < m && obstacleGrid[i][0] != 1) {
            dp[i][0] = 1;
            i++;
        }
        int j = 0;
        //左边界在不遇到障碍物时只有唯一路径
        while (j < n && obstacleGrid[0][j] != 1) {
            dp[0][j] = 1;
            j++;
        }
        for (int p = 1; p < m; p++) {
            for (int q = 1; q < n; q++) {
                //保证当前位置不是障碍物
                if (obstacleGrid[p][q] != 1) {
                    //动态方程
                    dp[p][q] = dp[p - 1][q] + dp[p][q - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
