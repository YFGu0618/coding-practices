package linkedin;

/**
 * LinkedIn OA 2018-2019: Shifting Strings
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class ShiftingStrings {

  private static final Scanner scanner = new Scanner(System.in);

  static String getShiftedString(String s, int leftShifts, int rightShifts) {
    int len = s.length();
    int left = (len + leftShifts - rightShifts) % len;
    StringBuilder sb = new StringBuilder(s.substring(left));
    sb.append(s.substring(0, left));
    return sb.toString();
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      String s = scanner.nextLine();
      String strShifts = scanner.nextLine();
      int[] sizes = Stream.of(strShifts.split("\\s+")).mapToInt(Integer::parseInt).toArray();
      System.out.println(getShiftedString(s, sizes[0], sizes[1]));
    }
  }
}
