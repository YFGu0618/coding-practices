package leetcode;

/**
 * LeetCode Solution No.0040.
 *
 * @see <a href="CombinationSumII">https://leetcode.com/problems/combination-sum-ii </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    dfs(0, candidates, target, result, new ArrayList<>());
    return result;
  }

  public static void dfs(int idx, int[] A, int rem, List<List<Integer>> res, List<Integer> l) {
    if (rem == 0) {
      res.add(new ArrayList<>(l));
      return;
    } else if (rem < 0) {
      return;
    }
    for (int i = idx; i < A.length; i++) {
      if (i > idx && A[i] == A[i - 1]) {
        continue;
      }
      l.add(A[i]);
      dfs(i + 1, A, rem - A[i], res, l);
      l.remove(l.size() - 1);
    }
  }
}
