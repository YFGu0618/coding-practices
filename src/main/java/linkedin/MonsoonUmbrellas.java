package linkedin;

/**
 * LinkedIn OA 2018-2019: Monsoon Umbrella
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class MonsoonUmbrellas {

  private static final Scanner scanner = new Scanner(System.in);

  static long getUmbrellas(int amount, int[] sizes) {
    if (sizes == null || sizes.length < 1) {
      return -1;
    }
    long[] dp = new long[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 0; i < sizes.length; i++) {
      for (int j = 1; j < dp.length; j++) {
        if (j <= sizes[i]) {
          dp[j] = Math.min(dp[j], dp[j - sizes[i]] + 1);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      int amount = Integer.valueOf(scanner.nextLine());
      String strSizes = scanner.nextLine();
      int[] sizes = Stream.of(strSizes.split("\\s+")).mapToInt(Integer::parseInt).toArray();
      System.out.println(getUmbrellas(amount, sizes));
    }
  }
}
