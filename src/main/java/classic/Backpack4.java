package classic;

/**
 * Backpack Problem 4: Single Pick, Number of Ways to Fill
 *
 * <p>Description: Given n items with size A[i] which an integer array and all positive numbers. An
 * integer m denotes the size of a backpack. Find the number of possible fill the backpack. Each
 * item may only be used once.
 *
 * <p>E.g.: Given 4 items with size [1, 2, 3, 3, 7], the backpack size is 7, then solution set is
 * [7] or [1, 3, 3], thus return 2.
 *
 * <p>Requirements: O(n*m) time and O(m) memory.
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Backpack4 {

  private static final Scanner sc = new Scanner(System.in);

  public static int backpack(int m, int[] A) {
    int[] dp = new int[m + 1];
    dp[0] = 1;
    for (int i = 0; i < A.length; i++) {
      for (int j = m; j >= 0; j--) {
        if (j >= A[i]) {
          dp[j] += dp[j - A[i]];
        }
      }
    }
    return dp[m];
  }

  public static void main(String[] args) throws IOException {
    while (sc.hasNext()) {
      int m = Integer.valueOf(sc.nextLine());
      String strA = sc.nextLine();
      int[] A = Arrays.stream(strA.split("\\s+")).mapToInt(Integer::valueOf).toArray();
      System.out.println("Single Pick, Number of Ways to Fill: " + backpack(m, A));
    }
    sc.close();
  }
}
