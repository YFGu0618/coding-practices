package leetcode;

/**
 * LeetCode Solution No.0309.
 *
 * @see <a href="BestTimeToBuyAndSellStockWithCooldown">
 *     https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown </a>
 * @author Yifan Gu
 */
public class BestTimeToBuyAndSellStockWithCooldown {
  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) {
      return 0;
    }
    int buy = -prices[0];
    int buy0 = 0;
    int sell = 0;
    int sell0 = 0;
    for (int price : prices) {
      buy0 = buy;
      buy = Math.max(buy0, sell0 - price);
      sell0 = sell;
      sell = Math.max(sell0, buy0 + price);
    }
    return sell;
  }
}
