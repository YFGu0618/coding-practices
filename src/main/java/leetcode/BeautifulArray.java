package leetcode;

/**
 * LeetCode Solution No.0932.
 *
 * @see <a href="BeautifulArray">https://leetcode.com/problems/beautiful-array </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.List;

public class BeautifulArray {
  public static int[] beautifulArray(int N) {
    List<Integer> result = new ArrayList<>();
    result.add(1);
    while (result.size() < N) {
      List<Integer> list = new ArrayList<>();
      for (int i : result) {
        if (i * 2 - 1 <= N) {
          list.add(i * 2 - 1);
        }
      }
      for (int i : result) {
        if (i * 2 <= N) {
          list.add(i * 2);
        }
      }
      result = list;
    }
    return result.stream().mapToInt(Integer::valueOf).toArray();
  }
}
