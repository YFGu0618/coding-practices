package leetcode;

/**
 * LeetCode Solution No.0035.
 *
 * @see <a href="SearchInsertPosition">https://leetcode.com/problems/search-insert-position </a>
 * @author Yifan Gu
 */
public class SearchInsertPosition {
  public static int searchInsert(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }
}
