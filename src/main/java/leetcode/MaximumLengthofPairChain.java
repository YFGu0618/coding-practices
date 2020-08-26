package leetcode;

import java.util.Arrays;

/**
 * LeetCode Solution No.0646.
 *
 * @see <a href="MaximumLengthofPairChain">
 *     https://leetcode.com/problems/maximum-length-of-pair-chain </a>
 * @author Yifan Gu
 */
public class MaximumLengthofPairChain {
  public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
    int[] dp = new int[pairs.length];
    Arrays.fill(dp, 1);
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < i; j++) {
        int chain = (pairs[i][0] > pairs[j][1]) ? dp[j] + 1 : dp[j];
        dp[i] = Math.max(dp[i], chain);
      }
    }
    return dp[pairs.length - 1];
  }
}
