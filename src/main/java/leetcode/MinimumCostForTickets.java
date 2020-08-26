package leetcode;

import java.util.Arrays;

/**
 * LeetCode Solution No.0983.
 *
 * @see <a href="MinimumCostForTickets">https://leetcode.com/problems/minimum-cost-for-tickets </a>
 * @author Yifan Gu
 */
public class MinimumCostForTickets {
  public int mincostTickets(int[] days, int[] costs) {
    Arrays.sort(days);
    int dp[] = new int[366];
    int idx = 0;
    for (int i = 1; i <= days[days.length - 1]; i++) {
      if (i < days[idx]) {
        dp[i] = dp[i - 1];
        continue;
      }
      idx++;
      dp[i] =
          Math.min(
              dp[i - 1] + costs[0],
              Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
    }
    return dp[days[days.length - 1]];
  }
}
