package leetcode;

/**
 * LeetCode Solution No.0016.
 *
 * @see <a href="ThreeSumClosest">https://leetcode.com/problems/3sum-closest </a>
 * @author Yifan Gu
 */
import java.util.Arrays;

public class ThreeSumClosest {
  public static int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int len = nums.length;
    int result = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < len - 2; i++) {
      // Some acceleration tricks
      // If current number equals to the previous one, meaning the case was already considered
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      // If the sum of current number and two of the largests is still less than target, continue
      if (nums[i] + nums[len - 1] + nums[len - 2] < target) {
        result = nums[i] + nums[len - 1] + nums[len - 2];
        continue;
      }
      // If three times current number is already larger than target, no need to check the largers
      if (nums[i] * 3 > target) {
        int tmp = nums[i] + nums[i + 1] + nums[i + 2];
        return Math.abs(tmp - target) < Math.abs(result - target) ? tmp : result;
      }
      // Trying to find the closest sum
      int left = i + 1;
      int right = len - 1;
      // The nums is arlready in non-decreasing order
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (Math.abs(sum - target) < Math.abs(result - target)) {
          result = sum;
        }
        if (sum < target) {
          left++;
        } else if (sum > target) {
          right--;
        } else {
          return sum;
        }
      }
    }
    return result;
  }
}
