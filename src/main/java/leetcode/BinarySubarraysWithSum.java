package leetcode;

/**
 * LeetCode Solution No.0930.
 *
 * @see <a href="BinarySubarraysWithSum">https://leetcode.com/problems/binary-subarrays-with-sum
 *     </a>
 * @author Yifan Gu
 */
public class BinarySubarraysWithSum {
  public static int numSubarraysWithSum(int[] A, int S) {
    int len = A.length;
    int count = 0;
    for (int i = 0; i < len; i++) {
      int sum = 0;
      for (int j = i; j < len; j++) {
        sum += A[j];
        if (sum == S) {
          count++;
        } else if (sum > S) {
          break;
        }
      }
    }
    return count;
  }
}
