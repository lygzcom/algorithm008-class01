package algorithmtraining.fourthweek;

/**
 * 529. 扫雷游戏
 * https://leetcode-cn.com/problems/minesweeper/
 */
public class UpdateBoard {
    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        char[][] board1 = updateBoard(board, new int[]{3, 0});
        for (char[] x : board1) {
            for (char y : x) {
                System.out.print(y + " ");

            }
            System.out.println();
        }

    }

    //相邻地址
    static int[][] position = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static char[][] updateBoard(char[][] board, int[] click) {
        int row = board.length;
        int col = board[0].length;
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        int num = 0;
        for (int[] p : position) {
            int x1 = x + p[0], y1 = y + p[1];
            if (x1 >= 0 && y1 >= 0 && x1 < row && y1 < col && board[x1][y1] == 'M') {
                num++;
            }
        }
        if (num > 0) {
            board[x][y] = (char) (num + '0');
            return board;

        }
        board[x][y] = 'B';
        for (int[] p : position) {
            int x1 = x + p[0], y1 = y + p[1];
            if (x1 >= 0 && y1 >= 0 && x1 < row && y1 < col && board[x1][y1] == 'E') {
                updateBoard(board, new int[]{x1, y1});
            }
        }
        return board;
    }

}
