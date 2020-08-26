package leetcode;

/**
 * LeetCode Solution No.0120.
 *
 * @see <a href="Triangle">https://leetcode.com/problems/triangle </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.List;

class Triangle {
  public static int minimumTotal(List<List<Integer>> triangle) {
    List<List<Integer>> dp = new ArrayList<>();
    dp.add(triangle.get(0));
    for (int i = 1; i < triangle.size(); i++) {
      List<Integer> pre = dp.get(i - 1);
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j < triangle.get(i).size(); j++) {
        int sum = triangle.get(i).get(j);
        if (j == 0) {
          sum += pre.get(0);
        } else if (j == pre.size()) {
          sum += pre.get(j - 1);
        } else {
          sum += Math.min(pre.get(j - 1), pre.get(j));
        }
        row.add(sum);
      }
      dp.add(row);
    }
    int min = Integer.MAX_VALUE;
    for (int i : dp.get(dp.size() - 1)) {
      min = Math.min(min, i);
    }
    return min;
  }
}
