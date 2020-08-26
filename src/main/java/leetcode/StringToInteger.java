package leetcode;

/**
 * LeetCode Solution No.0008.
 *
 * @see <a href="StringToInteger">https://leetcode.com/problems/string-to-integer-atoi </a>
 * @author Yifan Gu
 */
public class StringToInteger {
  public int myAtoi(String str) {
    if (str == null) {
      return 0;
    }
    int sign = 1;
    int i = 0;
    int result = 0;
    str = str.trim();
    if (str.isEmpty()) {
      return 0;
    }
    if (str.charAt(i) == '-' || str.charAt(i) == '+') {
      sign = str.charAt(i) == '-' ? -1 : 1;
      i++;
    }
    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
      if ((result > Integer.MAX_VALUE / 10)
          || result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7) {
        if (sign == 1) {
          return Integer.MAX_VALUE;
        } else {
          return Integer.MIN_VALUE;
        }
      }
      result = 10 * result + (str.charAt(i) - '0');
      i++;
    }
    return sign * result;
  }
}
