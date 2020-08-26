package leetcode;

/**
 * LeetCode Solution No.0338.
 *
 * @see <a href="CountingBits">https://leetcode.com/problems/counting-bits </a>
 * @author Yifan Gu
 */
public class CountingBits {
  public static int[] countBits(int num) {
    int[] res = new int[num + 1];
    for (int i = 1; i <= num; i++) {
      res[i] = res[i >> 1] + (i & 1);
    }
    return res;
  }
}
