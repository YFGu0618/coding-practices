package leetcode;

/**
 * LeetCode Solution No.0007.
 *
 * @see <a href="ReverseInteger">https://leetcode.com/problems/reverse-integer </a>
 * @author Yifan Gu
 */
public class ReverseInteger {
  public static int reverse(int x) {
    boolean isNegative = (x < 0);
    if (isNegative && x != Integer.MIN_VALUE) {
      x = -x;
    }
    int result = 0;
    while (x != 0) {
      int digit = x % 10;
      result = result * 10 + digit;
      if (result % 10 != digit) {
        return 0;
      }
      x /= 10;
    }
    return isNegative ? -result : result;
  }
}
