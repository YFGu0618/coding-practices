package leetcode;

/**
 * LeetCode Solution No.0738.
 *
 * @see <a href="MonotoneIncreasingDigits">https://leetcode.com/problems/monotone-increasing-digits
 *     </a>
 * @author Yifan Gu
 */
public class MonotoneIncreasingDigits {
  public static int monotoneIncreasingDigits(int N) {
    StringBuilder num = new StringBuilder(Integer.toString(N));
    int tail = num.length();
    for (int i = num.length() - 1; i > 0; i--) {
      if (num.charAt(i) < num.charAt(i - 1)) {
        tail = i;
        num.setCharAt(i - 1, (char) (num.charAt(i - 1) - 1));
      }
    }
    for (int i = tail; i < num.length(); i++) {
      num.setCharAt(i, '9');
    }
    return Integer.valueOf(num.toString());
  }
}
