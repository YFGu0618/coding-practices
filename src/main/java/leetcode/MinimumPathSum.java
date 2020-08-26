package leetcode;

/**
 * LeetCode Solution No.0064.
 *
 * @see <a href="MinimumPathSum">https://leetcode.com/problems/minimum-path-sum </a>
 * @author Yifan Gu
 */
public class MinimumPathSum {
  public static int minPathSum(int[][] grid) {
    int h = grid.length;
    int w = grid[0].length;
    int[][] dp = new int[h][w];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < h; i++) {
      dp[i][0] = grid[i][0] + dp[i - 1][0];
    }
    for (int i = 1; i < w; i++) {
      dp[0][i] = grid[0][i] + dp[0][i - 1];
    }
    for (int i = 1; i < h; i++) {
      for (int j = 1; j < w; j++) {
        dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    return dp[h - 1][w - 1];
  }
}
