package leetcode;

/**
 * LeetCode Solution No.0925.
 *
 * @see <a href="LongPressedName">https://leetcode.com/problems/long-pressed-name </a>
 * @author Yifan Gu
 */
public class LongPressedName {
  public static boolean isLongPressedName(String name, String typed) {
    if (name.length() < 1 || typed.length() < 1) {
      return false;
    } else if (name.equals(typed)) {
      return true;
    } else if (typed.charAt(0) != name.charAt(0)
        || typed.charAt(typed.length() - 1) != name.charAt(name.length() - 1)) {
      return false;
    }
    int n = 1;
    int t = 1;
    while (n < name.length() && t < typed.length()) {
      if (typed.charAt(t) != name.charAt(n)) {
        if (typed.charAt(t) != name.charAt(n - 1)) {
          return false;
        } else {
          t++;
        }
      } else {
        n++;
        t++;
      }
    }
    return true;
  }
}
