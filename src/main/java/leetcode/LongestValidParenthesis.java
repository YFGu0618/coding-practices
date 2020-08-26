package leetcode;

/**
 * LeetCode Solution No.0032.
 *
 * @see <a href="LongestValidParenthesis">https://leetcode.com/problems/longest-valid-parentheses
 *     </a>
 * @author Yifan Gu
 */
public class LongestValidParenthesis {
  public static int longestValidParentheses(String s) {
    int[] dp = new int[s.length()];
    int l = 0;
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        l++;
      } else if (l > 0) {
        l--;
        dp[i] = dp[i - 1] + 2;
        if (i - dp[i] >= 0) {
          dp[i] += dp[i - dp[i]];
        }
        max = Math.max(max, dp[i]);
      }
    }
    return max;
  }
}
