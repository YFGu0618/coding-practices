package leetcode;

/**
 * LeetCode Solution No.0121.
 *
 * @see <a href="BestTimeToBuyAndSellStock">
 *     https://leetcode.com/problems/best-time-to-buy-and-sell-stock </a>
 * @author Yifan Gu
 */
public class BestTimeToBuyAndSellStock {
  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }
    int[] dp = new int[prices.length];
    dp[0] = prices[0];
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < prices.length; i++) {
      for (int j = 0; j < i; j++) {
        dp[i] = Math.max(dp[i], prices[i] - prices[j]);
        max = Math.max(max, dp[i]);
      }
    }
    return max;
  }
}
