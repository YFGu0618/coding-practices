package leetcode;

/**
 * LeetCode Solution No.0027.
 *
 * @see <a href="RemoveElement">https://leetcode.com/problems/remove-element </a>
 * @author Yifan Gu
 */
public class RemoveElement {
  public static int removeElement(int[] nums, int val) {
    if (nums == null || nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0] == val ? 0 : 1;
    }
    int fill = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[fill++] = nums[i];
      }
    }
    return fill;
  }
}
