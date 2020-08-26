package leetcode;

/**
 * LeetCode Solution No.0041.
 *
 * @see <a href="FirstMissingPositive">https://leetcode.com/problems/first-missing-positive </a>
 * @author Yifan Gu
 */
public class FirstMissingPositive {
  public static int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 1;
    }
    int i = 0;
    while (i < nums.length) {
      if (nums[i] >= 0 && nums[i] < nums.length && nums[nums[i]] != nums[i]) {
        swap(nums, i, nums[i]);
      } else {
        i++;
      }
    }
    int min = 1;
    while (min < nums.length && nums[min] == min) {
      min++;
    }
    if (min >= nums.length) {
      min += (nums[0] == min) ? 1 : 0;
    }
    return min;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
