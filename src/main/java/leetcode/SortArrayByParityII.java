package leetcode;

/**
 * LeetCode Solution No.0922.
 *
 * @see <a href="SortArrayByParityII">https://leetcode.com/problems/sort-array-by-parity-ii </a>
 * @author Yifan Gu
 */
public class SortArrayByParityII {
  public static int[] sortArrayByParityII(int[] A) {
    for (int i = 0, j = 1; i < A.length && j < A.length; i += 2, j += 2) {
      while (i < A.length && A[i] % 2 == 0) {
        i += 2;
      }
      while (j < A.length && A[j] % 2 == 1) {
        j += 2;
      }
      if (i < A.length && j < A.length) {
        int tmp = A[j];
        A[j] = A[i];
        A[i] = tmp;
      }
    }
    return A;
  }
}
