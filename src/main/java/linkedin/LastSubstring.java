package linkedin;

/**
 * LinkedIn OA 2018-2019: Last Substring
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LastSubstring {

  private static final Scanner scanner = new Scanner(System.in);

  static String compute(String s) {
    List<String> list = new ArrayList<>();
    char maxCh = 'a';
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) > maxCh) {
        list.clear();
        maxCh = s.charAt(i);
      } else if (s.charAt(i) == maxCh) {
        list.add(s.substring(i));
      }
    }
    Collections.sort(list, Collections.reverseOrder());
    return list.get(0);
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      String s = scanner.nextLine();
      System.out.println(compute(s));
    }
  }
}
