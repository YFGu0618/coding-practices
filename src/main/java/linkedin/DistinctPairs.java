package linkedin;

/**
 * LinkedIn OA 2018-2019: Distinct Pairs
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class DistinctPairs {

  private static final Scanner scanner = new Scanner(System.in);

  static int numberOfPairs(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int pairs = 0;
    for (int num : nums) {
      int rem = k - num;
      if (map.containsKey(rem)) {
        if (map.get(rem) == -1) {
          map.put(rem, num);
          pairs++;
        }
      } else if (!map.containsKey(num)) {
        map.put(num, -1);
      }
    }
    return pairs;
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      String strNums = scanner.nextLine();
      int[] nums = Stream.of(strNums.split("\\s+")).mapToInt(Integer::parseInt).toArray();
      int k = Integer.valueOf(scanner.nextLine());
      System.out.println(numberOfPairs(nums, k));
    }
  }
}
