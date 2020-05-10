package algorithmtraining.thirdweek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 51. N皇后
 * https://leetcode-cn.com/problems/n-queens/
 */
public class SolveNQueens {
    public static void main(String[] args) {
        long startTime = System.nanoTime();   //获取开始时间
        for (List<String> a : solveNQueens(4)) {
            for (String b : a) {
                System.out.println(b + " ");
            }
            System.out.println("------------");
        }
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

    }

    public static List<List<String>> solveNQueens(int n) {
        if (n < 4) {
            Collections.emptyList();
        }
        List<List<String>> ans = new ArrayList<>();
        dfs(0, n, new String[n][n], new ArrayList<>(), ans);
        return ans;
    }

    public static void dfs(int row, int n, String[][] board, List<String> position, List<List<String>> ans) {
        if (row >= n) {
            ans.add(new ArrayList<>(position));
            return;
        }
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (isValid(board, row, col)) {
                //合法继续
                board[row][col] = "Q";
                position.add(drawLine(col, n));
                dfs(row + 1, n, board, position, ans);
                //撤销选择
                board[row][col] = ".";
                position.remove(row);
            } else {
                continue;
            }

        }

    }

    public static String drawLine(int col, int n) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == col) {
                line.append("Q");
            } else {
                line.append(".");
            }
        }
        return line.toString();
    }

    public static boolean isValid(String[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if ("Q".equals(board[i][col]))
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if ("Q".equals(board[i][j]))
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(board[i][j]))
                return false;
        }
        return true;

    }
}
