package classic;

/**
 * Backpack Problem 1: Single Pick, Max Filled
 *
 * <p>Description: Given n items with size A[i], an integer m denotes the size of a backpack. How
 * full you can fill this backpack?
 *
 * <p>E.g.: If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3,
 * 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can
 * select [2, 3, 7] so that we can fulfill the backpack.
 *
 * <p>Requirements: O(n*m) time and O(m) memory.
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Backpack1 {

  private static final Scanner sc = new Scanner(System.in);

  public static int backpack(int m, int[] A) {
    int[] dp = new int[m + 1];
    for (int i = 0; i < A.length; i++) {
      for (int j = m; j > 0; j--) {
        if (j >= A[i]) {
          dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
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
      System.out.println("Single Pick, Max Filled: " + backpack(m, A));
    }
    sc.close();
  }
}
