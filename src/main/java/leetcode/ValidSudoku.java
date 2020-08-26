package leetcode;

/**
 * LeetCode Solution No.0036.
 *
 * @see <a href="ValidSudoku">https://leetcode.com/problems/valid-sudoku </a>
 * @author Yifan Gu
 */
public class ValidSudoku {
  public static boolean isValidSudoku(char[][] board) {
    int[][] rowCount = new int[9][9];
    int[][] colCount = new int[9][9];
    int[][] grdCount = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char ch = board[i][j];
        if (ch == '.') {
          continue;
        }
        int c = ch - '1';
        int grd = (i / 3) * 3 + j / 3;
        rowCount[i][c]++;
        colCount[j][c]++;
        grdCount[grd][c]++;
        if (rowCount[i][c] > 1 || colCount[j][c] > 1 || grdCount[grd][c] > 1) {
          return false;
        }
      }
    }
    return true;
  }
}
