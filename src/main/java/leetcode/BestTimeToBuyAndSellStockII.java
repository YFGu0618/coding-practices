package leetcode;

/**
 * LeetCode Solution No.0122.
 *
 * @see <a href="BestTimeToBuyAndSellStockII">
 *     https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii </a>
 * @author Yifan Gu
 */
public class BestTimeToBuyAndSellStockII {
  public int maxProfit(int[] prices) {
    int profit = 0;
    int i = 0;
    while (i < prices.length) {
      // find next local minimum
      while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
        i++;
      }
      int min = prices[i++]; // need increment to avoid infinite loop for "[1]"
      // find next local maximum
      while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
        i++;
      }
      profit += (i < prices.length) ? prices[i++] - min : 0;
    }
    return profit;
  }
}
