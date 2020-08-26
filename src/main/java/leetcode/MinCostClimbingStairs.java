package leetcode;

/**
 * LeetCode Solution No.0746.
 *
 * @see <a href="MinCostClimbingStairs">https://leetcode.com/problems/min-cost-climbing-stairs </a>
 * @author Yifan Gu
 */
public class MinCostClimbingStairs {
  public static int minCostClimbingStairs(int[] cost) {
    if (cost == null || cost.length <= 1) {
      return 0;
    } else if (cost.length == 2) {
      return Math.min(cost[0], cost[1]);
    }
    int[] dp = new int[cost.length];
    dp[0] = cost[0];
    dp[1] = cost[1];
    for (int i = 2; i < cost.length; i++) {
      dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
    }
    return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
  }
}
