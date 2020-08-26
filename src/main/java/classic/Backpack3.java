package classic;

/**
 * Backpack Problem 3: Infinite Pick, Max Value
 *
 * <p>Description: Given n kind of items with size A[i] and value V[i] (each item has an infinite
 * number available) and a backpack with size m. What's the maximum value can you put into the
 * backpack?
 *
 * <p>E.g.: Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size
 * 10. The maximum value is 15.
 *
 * <p>Requirements: O(n*m) time and O(m) memory.
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Backpack3 {

  private static final Scanner sc = new Scanner(System.in);

  public static int backpack(int m, int[] A, int[] V) {
    int[] dp = new int[m + 1];
    for (int i = 0; i < A.length; i++) {
      for (int j = 1; j <= m; j++) {
        if (j >= A[i]) {
          dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
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
      String strV = sc.nextLine();
      int[] V = Arrays.stream(strV.split("\\s+")).mapToInt(Integer::valueOf).toArray();
      System.out.println("Infinite Pick, Max Value: " + backpack(m, A, V));
    }
    sc.close();
  }
}
