package leetcode;

/**
 * LeetCode Solution No.0038.
 *
 * @see <a href="CountAndSay">https://leetcode.com/problems/count-and-say </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.List;

public class CountAndSay {
  private static List<String> list;

  public static String countAndSay(int n) {
    if (list != null && list.size() >= n) {
      return list.get(n - 1);
    } else if (list == null) {
      list = new ArrayList<>();
      list.add("1");
    }
    StringBuilder sb = new StringBuilder(list.get(list.size() - 1));
    for (int i = list.size(); i < n; i++) {
      String pre = sb.toString();
      sb = new StringBuilder();
      int count = 1;
      for (int j = 1; j < pre.length(); j++) {
        if (pre.charAt(j) == pre.charAt(j - 1)) {
          count++;
        } else {
          sb.append(count);
          sb.append(pre.charAt(j - 1));
          count = 1;
        }
      }
      sb.append(count);
      sb.append(pre.charAt(pre.length() - 1));
      list.add(sb.toString());
    }
    return list.get(n - 1);
  }
}
