package linkedin;

/**
 * LinkedIn OA 2018-2019: Cut The Sticks
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class CutTheSticks {

  private static final Scanner scanner = new Scanner(System.in);

  static List<Integer> cutSticks(int[] sticks) {
    Arrays.sort(sticks);
    List<Integer> list = new ArrayList<>();
    list.add(sticks.length);
    for (int i = 1; i < sticks.length; i++) {
      if (sticks[i] != sticks[i - 1]) {
        list.add(sticks.length - i);
      }
    }
    return list;
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      String strNums = scanner.nextLine();
      int[] nums = Stream.of(strNums.split("\\s+")).mapToInt(Integer::parseInt).toArray();
      System.out.println(cutSticks(nums));
    }
  }
}
