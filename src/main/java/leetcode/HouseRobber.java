package leetcode;

/**
 * LeetCode Solution No.0198.
 *
 * @see <a href="HouseRobber">https://leetcode.com/problems/house-robber </a>
 * @author Yifan Gu
 */
public class HouseRobber {
  public static int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    dp[2] = nums[1];
    for (int i = 2; i < nums.length; i++) {
      dp[i + 1] = nums[i] + Math.max(dp[i - 1], dp[i - 2]);
    }
    return Math.max(dp[nums.length - 1], dp[nums.length]);
  }
}
