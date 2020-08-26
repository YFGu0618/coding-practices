package leetcode;

/**
 * LeetCode Solution No.0046.
 *
 * @see <a href="Permutations">https://leetcode.com/problems/permutations </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.List;

public class Permutations {
  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), nums);
    return result;
  }

  public static void backtrack(List<List<Integer>> list, List<Integer> tmpList, int[] nums) {
    if (tmpList.size() == nums.length) {
      list.add(new ArrayList<>(tmpList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        // Assumes that all numbers in nums are unique, therefore cases like [1,1,2] won't work
        if (tmpList.contains(nums[i])) {
          continue;
        }
        tmpList.add(nums[i]);
        backtrack(list, tmpList, nums);
        tmpList.remove(tmpList.size() - 1);
      }
    }
  }
}
