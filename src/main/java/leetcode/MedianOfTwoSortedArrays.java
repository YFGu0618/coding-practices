package leetcode;

/**
 * LeetCode Solution No.0004.
 *
 * @see <a href="MedianOfTwoSortedArrays">https://leetcode.com/problems/median-of-two-sorted-arrays
 *     </a>
 * @author Yifan Gu
 */
public class MedianOfTwoSortedArrays {
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    if (len1 > len2) { // Ensure nums1 is shorter than nums2
      return findMedianSortedArrays(nums2, nums1);
    }
    int mid = (len1 + len2 + 1) / 2; // Amount of numbers left to the final median (inclusive)
    // Trying to find cutting points in nums1 and nums2
    int start = 0;
    int end = len1;
    while (start < end) {
      int cut1 = start + (end - start) / 2; // Cutting point in nums1
      int cut2 = mid - (cut1 + 1) - 1; // Adjust cutting point in nums2 according to cut1
      if (nums1[cut1] < nums2[cut2 + 1]) {
        // cut1 is smaller than the target value
        start = cut1 + 1;
      } else {
        // cut1 is larger than the target value
        end = cut1;
      }
    }

    // If total amount is odd
    // start==0: final median is not in nums1
    int midNums1 = (start == 0) ? Integer.MIN_VALUE : nums1[start - 1];
    // mid-start==0: final median is not in nums2
    int midNums2 = (mid - start == 0) ? Integer.MIN_VALUE : nums2[mid - start - 1];
    int median1 = Math.max(midNums1, midNums2);

    // If total amount is even
    // start==len1: final median is not in nums1
    midNums1 = (start == len1) ? Integer.MAX_VALUE : nums1[start];
    // mid-start==len2: final median is not in nums2
    midNums2 = (mid - start == len2) ? Integer.MAX_VALUE : nums2[mid - start];
    int median2 = Math.min(midNums1, midNums2);

    // Return the final median according to the total amount of numbers
    if ((len1 + len2) % 2 == 1) {
      return median1;
    } else {
      return (median1 + median2) / 2D;
    }
  }
}
