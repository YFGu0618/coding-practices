package leetcode;

/**
 * LeetCode Solution No.0386.
 *
 * @see <a href="LexicographicalNumbers">https://leetcode.com/problems/lexicographical-numbers </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
  public static List<Integer> lexicalOrder(int n) {
    List<Integer> result = new ArrayList<>();
    if (n < 10) {
      for (int i = 1; i <= n; i++) {
        result.add(i);
      }
      return result;
    }
    for (int i = 1; i <= 9; i++) {
      result.add(i);
      result = build(n, result);
    }
    return build(n, result);
  }

  public static List<Integer> build(int n, List<Integer> list) {
    if (list.size() == n) {
      return list;
    } else if (list.get(list.size() - 1) * 10 > n) {
      return list;
    }
    int last = list.get(list.size() - 1);
    for (int i = 0; i <= 9; i++) {
      int newLast = last * 10 + i;
      if (newLast > n) {
        continue;
      } else {
        list.add(newLast);
      }
      build(n, list);
    }
    return list;
  }
}
