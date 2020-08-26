package twitter;

/**
 * Twitter OA 2018-2019: Hackerland Election
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Scanner;

public class AsciiEncodedString {

  private static final Scanner scanner = new Scanner(System.in);

  static String decode(String encoded) {
    // Write your code here
    StringBuilder sb = new StringBuilder();
    StringBuilder r = new StringBuilder(encoded);
    String code = r.reverse().toString();
    int left = 0;
    int right = 2;
    while (left < right && right < code.length()) {
      String c = code.substring(left, right);
      if (valid(c)) {
        sb.append((char) Integer.parseInt(c));
        left = right;
        right = left + 2;
      } else {
        right++;
      }
    }
    return sb.toString();
  }

  static boolean valid(String s) {
    int c = Integer.valueOf(s);
    if ((c >= 65 && c <= 90) || c == 32 || (c >= 97 && c <= 122)) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      String str = scanner.nextLine();
      System.out.println(decode(str));
    }
  }
}
