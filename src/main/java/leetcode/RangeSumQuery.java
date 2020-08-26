package leetcode;

/**
 * LeetCode Solution No.0303.
 *
 * @see <a href="RangeSumQuery">https://leetcode.com/problems/range-sum-query-immutable </a>
 * @author Yifan Gu
 */
public class RangeSumQuery {
  public class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
      for (int i = 1; i < nums.length; i++) {
        nums[i] += nums[i - 1];
      }
      this.nums = nums;
    }

    public int sumRange(int i, int j) {
      if (i == 0) {
        return nums[j];
      }
      return nums[j] - nums[i - 1];
    }
  }
}
