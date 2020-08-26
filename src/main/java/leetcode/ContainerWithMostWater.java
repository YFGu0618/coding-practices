package leetcode;

/**
 * LeetCode Solution No.0011.
 *
 * @see <a href="ContainerWithMostWater">https://leetcode.com/problems/container-with-most-water
 *     </a>
 * @author Yifan Gu
 */
public class ContainerWithMostWater {
  public static int maxArea(int[] height) {
    int maxCapacity = Integer.MIN_VALUE;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      maxCapacity = Math.max(maxCapacity, (right - left) * Math.min(height[left], height[right]));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return maxCapacity;
  }
}
