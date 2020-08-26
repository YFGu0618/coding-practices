package leetcode;

/**
 * LeetCode Solution No.0081.
 *
 * @see <a href="SearchInRotatedSortedArrayII">
 *     https://leetcode.com/problems/search-in-rotated-sorted-array-i </a>
 * @author Yifan Gu
 */
public class SearchInRotatedSortedArrayII {
  public static boolean search(int[] nums, int target) {
    if (nums == null || nums.length < 1) {
      return false;
    }
    int low = 0;
    int high = nums.length - 1;
    while (low < high) {
      int mid = (low + high) / 2;
      if (nums[mid] == target) {
        return true;
      } else if (nums[mid] > nums[high]) {
        if (nums[mid] > target && nums[low] <= target) {
          high = mid;
        } else {
          low = mid + 1;
        }
      } else if (nums[mid] < nums[high]) {
        if (nums[mid] < target && nums[high] >= target) {
          low = mid + 1;
        } else {
          high = mid;
        }
      } else {
        high--;
      }
    }
    return nums[low] == target ? true : false;
  }
}
