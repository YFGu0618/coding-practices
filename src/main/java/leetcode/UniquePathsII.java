package leetcode;

/**
 * LeetCode Solution No.0063.
 *
 * @see <a href="UniquePathsII">https://leetcode.com/problems/unique-paths-ii </a>
 * @author Yifan Gu
 */
public class UniquePathsII {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int h = obstacleGrid.length;
    int w = obstacleGrid[0].length;
    int[][] dp = new int[h + 1][w + 1];
    dp[1][0] = 1;
    for (int i = 1; i <= obstacleGrid.length; i++) {
      for (int j = 1; j <= obstacleGrid[0].length; j++) {
        dp[i][j] = (obstacleGrid[i - 1][j - 1] == 1) ? 0 : dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[h][w];
  }
}
