package classic;

/**
 * Backpack Problem 6: Infinite Pick, No Duplicates, Number of Ways to Fill (Permutation)
 *
 * <p>Description: Given an integer array A[i] with all positive numbers and no duplicates, find the
 * number of possible combinations that add up to a positive integer m.
 *
 * <p>E.g.: Given 4 items with size [1, 2, 4], the backpack size is 4, then solution set is [1, 1,
 * 1, 1], [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 2], [4], thus return 6.
 *
 * <p>Requirements: O(n*m) time and O(m) memory.
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Backpack6 {

  private static final Scanner sc = new Scanner(System.in);

  public static int backpack(int m, int[] A) {
    int[] dp = new int[m + 1];
    dp[0] = 1;
    for (int i = 1; i <= m; i++) {
      for (int a : A) {
        if (a <= i) dp[i] += dp[i - a];
      }
    }
    return dp[m];
  }

  public static void main(String[] args) throws IOException {
    while (sc.hasNext()) {
      int m = Integer.valueOf(sc.nextLine());
      String strA = sc.nextLine();
      int[] A = Arrays.stream(strA.split("\\s+")).mapToInt(Integer::valueOf).toArray();
      System.out.println(
          "Infinite Pick, No Duplicates, Number of Ways to Fill (Permutation): " + backpack(m, A));
    }
    sc.close();
  }
}
