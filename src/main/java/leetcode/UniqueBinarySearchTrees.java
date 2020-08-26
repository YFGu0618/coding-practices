package leetcode;

/**
 * LeetCode Solution No.0096.
 *
 * @see <a href="UniqueBinarySearchTrees">https://leetcode.com/problems/unique-binary-search-trees
 *     </a>
 * @author Yifan Gu
 */
public class UniqueBinarySearchTrees {
  public static int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] += dp[j - 1] * dp[i - j];
      }
    }
    return dp[n];
  }
}
