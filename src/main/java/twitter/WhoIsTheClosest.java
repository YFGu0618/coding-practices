package twitter;

/**
 * Twitter OA 2018-2019: Who is the Closest
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class WhoIsTheClosest {

  private static final Scanner scanner = new Scanner(System.in);

  static int[] closest(String s, int[] queries) {
    int[] result = new int[queries.length];
    Arrays.fill(result, -1);
    for (int i = 0; i < queries.length; i++) {
      int q = queries[i];
      char ch = s.charAt(q);
      int left = q - 1;
      int right = q + 1;
      while (left >= 0 || right < s.length()) {
        if (left >= 0 && s.charAt(left) == ch) {
          result[i] = left;
          break;
        } else if (right < s.length() && s.charAt(right) == ch) {
          result[i] = right;
          break;
        } else {
          left--;
          right++;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      String s = scanner.nextLine();
      int n = Integer.valueOf(scanner.nextLine());
      int[] queries = new int[n];
      for (int i = 0; i < n; i++) {
        queries[i] = Integer.valueOf(scanner.nextLine());
      }
      System.out.println(Arrays.toString(closest(s, queries)));
    }
  }
}
