package leetcode;

/**
 * LeetCode Solution No.0304.
 *
 * @see <a href="RangeSumQuery2D">https://leetcode.com/problems/range-sum-query-2d-immutable </a>
 * @author Yifan Gu
 */
public class RangeSumQuery2D {
  public class NumMatrix {
    private int[][] sums;

    public NumMatrix(int[][] matrix) {
      int row = matrix.length;
      int col = matrix[0].length;
      sums = new int[row + 1][col + 1];
      for (int i = 1; i <= row; i++) {
        for (int j = 1; j <= col; j++) {
          sums[i][j] = matrix[i - 1][j - 1] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
        }
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      return sums[row2 + 1][col2 + 1]
          - sums[row2 + 1][col1]
          - sums[row1][col2 + 1]
          + sums[row1][col1];
    }
  }
}
