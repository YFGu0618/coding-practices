package leetcode;

/**
 * LeetCode Solution No.0044.
 *
 * @see <a href="WildcardMatching">https://leetcode.com/problems/wildcard-matching </a>
 * @author Yifan Gu
 */
public class WildcardMatching {
  public static boolean isMatch(String s, String p) {
    // 2D array for dp
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[s.length()][p.length()] = true;
    // Edge case
    for (int i = p.length() - 1; i >= 0; i--) {
      if (p.charAt(i) == '*') {
        dp[s.length()][i] = true;
      } else {
        break;
      }
    }
    // Traversing the string and the pattern
    for (int i = s.length() - 1; i >= 0; i--) {
      for (int j = p.length() - 1; j >= 0; j--) {
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
          dp[i][j] = dp[i + 1][j + 1];
        } else if (p.charAt(j) == '*') {
          dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
        } else {
          dp[i][j] = false;
        }
      }
    }
    return dp[0][0];
  }
}
