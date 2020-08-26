package leetcode;

/**
 * LeetCode Solution No.0926.
 *
 * @see <a href="FlipStringToMonotoneIncreasing">
 *     https://leetcode.com/problems/flip-string-to-monotone-increasing </a>
 * @author Yifan Gu
 */
public class FlipStringToMonotoneIncreasing {
  public static int minFlipsMonoIncr(String S) {
    int len = S.length();
    if (len <= 1) {
      return 0;
    }
    int[][] dp = new int[len + 1][2];
    for (int i = 1; i <= len; i++) {
      if (S.charAt(i - 1) == '0') {
        dp[i][0] = dp[i - 1][0];
        dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
      } else {
        dp[i][0] = dp[i - 1][0] + 1;
        dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
      }
    }
    return Math.min(dp[len][0], dp[len][1]);
  }
}
