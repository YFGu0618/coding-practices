package twitter;

/**
 * Twitter OA 2018-2019: Primes in Subtree
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoPairsAllowed {

  private static final Scanner scanner = new Scanner(System.in);

  static List<Integer> minimumOperations(List<String> words) {
    List<Integer> result = new ArrayList<>();
    for (String w : words) {
      int ops = 0;
      int num = 1;
      for (int i = 1; i < w.length(); i++) {
        if (w.charAt(i) == w.charAt(i - 1)) {
          num++;
        } else {
          ops += (int) (num / 2);
          num = 1;
        }
      }
      if (num > 1) {
        ops += (int) (num / 2);
      }
      result.add(ops);
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      int n = Integer.valueOf(scanner.nextLine());
      // Starts
      List<String> words = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        words.add(scanner.nextLine());
      }
      System.out.println(minimumOperations(words).toString());
    }
  }
}
