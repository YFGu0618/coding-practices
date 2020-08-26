package leetcode;

/**
 * LeetCode Solution No.0047.
 *
 * @see <a href="PermutationsII">https://leetcode.com/problems/permutations-ii </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
  public static List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
    return result;
  }

  public static void backtrack(
      List<List<Integer>> list, List<Integer> tmpList, int[] nums, boolean[] flags) {
    if (tmpList.size() == nums.length) {
      list.add(new ArrayList<>(tmpList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        // If the number is used, or it is the same as previous one`
        if (flags[i] || i > 0 && nums[i] == nums[i - 1] && !flags[i - 1]) {
          continue;
        }
        flags[i] = true;
        tmpList.add(nums[i]);
        backtrack(list, tmpList, nums, flags);
        flags[i] = false;
        tmpList.remove(tmpList.size() - 1);
      }
    }
  }
}
