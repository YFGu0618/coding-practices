package leetcode;

/**
 * LeetCode Solution No.0053.
 *
 * @see <a href="MaximumSubarray">https://leetcode.com/problems/maximum-subarray </a>
 * @author Yifan Gu
 */
public class MaximumSubarray {
  public static int maxSubArray(int[] nums) {
    int[] dp = new int[nums.length];
    int max = nums[0];
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
