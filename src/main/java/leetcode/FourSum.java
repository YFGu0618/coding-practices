package leetcode;

/**
 * LeetCode Solution No.0018.
 *
 * @see <a href="FourSum">https://leetcode.com/problems/4sum </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    int len = nums.length;
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < len - 3; i++) {
      // If first candidate already too big
      if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
        break;
      }
      // If last candidate still too small
      if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
        continue;
      }
      // Avoid duplicate when iterating i
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < len - 2; j++) {
        // If first candidate already too big
        if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
          break;
        }
        // If last candidate already too small
        if (nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
          continue;
        }
        int left = j + 1;
        int right = len - 1;
        while (left < right) {
          int sum = nums[i] + nums[j] + nums[left] + nums[right];
          if (sum == target) {
            result.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
            // Avoid duplicate when iterating left and right
            while (left < right && nums[left] == nums[left - 1]) {
              left++;
            }
            while (left < right && nums[right] == nums[right + 1]) {
              right--;
            }
          } else if (sum < target) {
            left++;
          } else {
            right--;
          }
        }
        // Avoid duplicate when iterating j
        while (j < len - 1 && nums[j] == nums[j + 1]) {
          j++;
        }
      }
    }
    return result;
  }
}
