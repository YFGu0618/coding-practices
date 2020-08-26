package leetcode;

/**
 * LeetCode Solution No.0123.
 *
 * @see <a href="BestTimeToBuyAndSellStockIII">
 *     https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii </a>
 * @author Yifan Gu
 */
public class BestTimeToBuyAndSellStockIII {
  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) {
      return 0;
    }
    int total = 2;
    int[] dp = new int[prices.length];
    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= total; i++) {
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
}
