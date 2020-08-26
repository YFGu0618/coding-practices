package leetcode;

/**
 * LeetCode Solution No.0413.
 *
 * @see <a href="ArithmeticSlices">https://leetcode.com/problems/arithmetic-slices </a>
 * @author Yifan Gu
 */
public class ArithmeticSlices {
  public int numberOfArithmeticSlices(int[] A) {
    int sum = 0;
    int curr = 0;
    for (int i = 2; i < A.length; i++) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        curr++;
        sum += curr;
      }
    }
    return sum;
  }
}
