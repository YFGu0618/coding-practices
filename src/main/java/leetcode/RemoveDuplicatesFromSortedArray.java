package leetcode;

/**
 * LeetCode Solution No.0026.
 *
 * @see <a href="RemoveDuplicatesFromSortedArray">
 *     https://leetcode.com/problems/remove-duplicates-from-sorted-array </a>
 * @author Yifan Gu
 */
public class RemoveDuplicatesFromSortedArray {
  public static int removeDuplicates(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int fill = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[fill]) {
        nums[++fill] = nums[i];
      }
    }
    return fill + 1;
  }
}
