package leetcode;

/**
 * LeetCode Solution No.0031.
 *
 * @see <a href="NextPermutation">https://leetcode.com/problems/next-permutation </a>
 * @author Yifan Gu
 */
public class NextPermutation {
  public static void nextPermutation(int[] nums) {
    if (nums.length < 2) {
      return;
    }
    int index = nums.length - 1;
    while (index > 0) {
      if (nums[index] > nums[index - 1]) {
        break;
      }
      index--;
    }
    if (index == 0) {
      reverse(nums, 0, nums.length - 1);
      return;
    } else {
      int i = nums.length - 1;
      while (i >= index) {
        if (nums[i] > nums[index - 1]) {
          break;
        }
        i--;
      }
      swap(nums, i, index - 1);
      reverse(nums, index, nums.length - 1);
    }
  }

  public static void reverse(int[] nums, int start, int end) {
    if (start > end) {
      return;
    }
    for (int i = start; i <= (start + end) / 2; i++) {
      swap(nums, i, end - (i - start));
    }
  }

  public static void swap(int[] nums, int i1, int i2) {
    int tmp = nums[i1];
    nums[i1] = nums[i2];
    nums[i2] = tmp;
  }
}
