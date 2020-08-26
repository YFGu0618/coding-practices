package leetcode;

/**
 * LeetCode Solution No.0070.
 *
 * @see <a href="ClimbingStairs">https://leetcode.com/problems/climbing-stairs </a>
 * @author Yifan Gu
 */
public class ClimbingStairs {
  public static int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n - 1];
  }
}
