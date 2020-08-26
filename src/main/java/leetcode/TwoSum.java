package leetcode;

/**
 * LeetCode Solution No.0001.
 *
 * @see <a href="TwoSum">https://leetcode.com/problems/two-sum </a>
 * @author Yifan Gu
 */
import java.util.HashMap;

public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] resIdx = new int[2];
    for (int i = 0; i < nums.length; i++) {
      int remain = target - nums[i];
      if (map.containsKey(remain)) {
        resIdx[0] = map.get(remain);
        resIdx[1] = i;
        break;
      }
      map.put(nums[i], i);
    }
    return resIdx;
  }
}
