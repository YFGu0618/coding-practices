package leetcode;

/**
 * LeetCode Solution No.0033.
 *
 * @see <a href="SearchInRotatedSortedArray">
 *     https://leetcode.com/problems/search-in-rotated-sorted-array </a>
 * @author Yifan Gu
 */
public class SearchInRotatedSortedArray {
  public static int search(int[] nums, int target) {
    if (nums.length == 1) {
      return nums[0] == target ? 0 : -1;
    }
    int low = 0;
    int high = nums.length;
    while (low < high) {
      int mid = (low + high) / 2;
      boolean flag = ((target < nums[0]) == (nums[mid] < nums[0]));
      int tmp = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      int num = flag ? nums[mid] : tmp;
      if (num == target) {
        return mid;
      } else if (num < target) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return -1;
  }
}
