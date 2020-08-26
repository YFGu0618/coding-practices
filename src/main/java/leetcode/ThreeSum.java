package leetcode;

/**
 * LeetCode Solution No.0015.
 *
 * @see <a href="ThreeSum">https://leetcode.com/problems/3sum </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int target = -nums[i];
      int left = i + 1;
      int right = nums.length - 1;
      // The nums is arlready in non-decreasing order
      while (left < right) {
        if (nums[left] + nums[right] < target) {
          left++;
        } else if (nums[left] + nums[right] > target) {
          right--;
        } else {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }
          left++;
          right--;
        }
      }
    }
    return result;
  }
}
