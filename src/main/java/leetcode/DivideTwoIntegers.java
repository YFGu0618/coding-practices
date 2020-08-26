package leetcode;

/**
 * LeetCode Solution No.0029.
 *
 * @see <a href="DivideTwoIntegers">https://leetcode.com/problems/divide-two-integers </a>
 * @author Yifan Gu
 */
public class DivideTwoIntegers {
  public static int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }
    if (dividend > 0 && divisor > 0) {
      return divideHelper(-dividend, -divisor);
    } else if (dividend > 0) {
      return -divideHelper(-dividend, divisor);
    } else if (divisor > 0) {
      return -divideHelper(dividend, -divisor);
    } else {
      return divideHelper(dividend, divisor);
    }
  }

  public static int divideHelper(int dividend, int divisor) {
    if (divisor < dividend) {
      return 0;
    }
    int cur = 0, res = 0;
    while ((divisor << cur) >= dividend && (divisor << cur) < 0 && cur < 31) {
      cur++;
    }
    res = dividend - (divisor << cur - 1);
    if (res > divisor) {
      return 1 << cur - 1;
    }
    return (1 << cur - 1) + divide(res, divisor);
  }
}
