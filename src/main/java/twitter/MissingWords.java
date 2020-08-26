package twitter;

/**
 * Twitter OA 2018-2019: Missing Words
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MissingWords {

  private static final Scanner scanner = new Scanner(System.in);

  static String[] missingWords(String[] s, String[] t) {
    String[] result = new String[s.length - t.length];
    int idx = 0;
    int idxs = 0;
    int idxt = 0;
    while (idxs < s.length && idxt < t.length) {
      if (!s[idxs].equals(t[idxt])) {
        result[idx++] = s[idxs++];
      } else {
        idxs++;
        idxt++;
      }
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      String[] s = scanner.nextLine().split("\\s+");
      String[] t = scanner.nextLine().split("\\s+");
      System.out.println(Arrays.toString(missingWords(s, t)));
    }
  }
}
