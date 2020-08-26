package leetcode;

/**
 * LeetCode Solution No.0039.
 *
 * @see <a href="CombinationSum">https://leetcode.com/problems/combination-sum </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    dfs(0, candidates, target, result, new ArrayList<>());
    // result = dp(candidates, target);
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
      l.add(A[i]);
      dfs(i, A, rem - A[i], res, l);
      l.remove(l.size() - 1);
    }
  }

  public static List<List<Integer>> dp(int[] A, int m) {
    List<List<List<Integer>>> dp = new ArrayList<>();
    for (int i = 1; i <= m; i++) {
      List<List<Integer>> list = new ArrayList<>();
      for (int j = 0; j < A.length && A[j] <= i; j++) {
        if (i == A[j]) {
          list.add(Arrays.asList(A[j]));
        } else {
          List<List<Integer>> tmp = dp.get(i - A[j] - 1);
          for (List<Integer> l : tmp) {
            if (A[j] <= l.get(0)) {
              List<Integer> nl = new ArrayList<>(l);
              nl.add(0, A[j]);
              list.add(nl);
            }
          }
        }
      }
      dp.add(list);
    }
    return dp.get(m - 1);
  }
}
