package leetcode;

/**
 * LeetCode Solution No.0188.
 *
 * @see <a href="BestTimeToBuyAndSellStockIV">
 *     https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv </a>
 * @author Yifan Gu
 */
public class BestTimeToBuyAndSellStockIV {
  public static int maxProfit(int k, int[] prices) {
    if (prices == null || prices.length <= 1 || k == 0) {
      return 0;
    }
    if (k >= prices.length / 2) {
      return maxProfit(prices);
    }
    int[] dp = new int[prices.length];
    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= k; i++) {
      int balance = dp[0] - prices[0];
      for (int j = 1; j < prices.length; j++) {
        int prev = dp[j];
        dp[j] = Math.max(dp[j - 1], balance + prices[j]);
        max = Math.max(max, dp[j]);
        balance = Math.max(balance, prev - prices[j]);
      }
    }
    return max;
  }

  private static int maxProfit(int[] prices) {
    int max = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        max += prices[i] - prices[i - 1];
      }
    }
    return max;
  }
}
