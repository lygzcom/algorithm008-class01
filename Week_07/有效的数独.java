package algorithmtraining.第七周;

public class 有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] res = new boolean[27][9];
        int row, col, temp;
        for (int i = 0; i < 9; i++) {
            temp = i / 3 * 3 + 18;
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                col = board[i][j] - '1';
                if (res[i][col] || res[j + 9][col] || res[temp + j / 3][col]) {
                    return false;
                }
                res[i][col] = true;
                res[j + 9][col] = true;
                res[temp + j / 3][col] = true;
            }
        }
        return true;

    }
}
