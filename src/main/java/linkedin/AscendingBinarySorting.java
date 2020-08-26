package linkedin;

/**
 * LinkedIn OA 2018-2019: Ascending Binary Sorting
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class AscendingBinarySorting {

  private static final Scanner scanner = new Scanner(System.in);

  static int[] rearrange(int[] nums) {
    Integer[] sorted = new Integer[nums.length];
    for (int i = 0; i < nums.length; i++) {
      sorted[i] = Integer.valueOf(nums[i]);
    }
    Arrays.sort(
        sorted,
        new Comparator<Integer>() {
          @Override
          public int compare(Integer a, Integer b) {
            return bin1(a) == bin1(b) ? a - b : bin1(a) - bin1(b);
          }
        });
    return Arrays.stream(sorted).mapToInt(Integer::intValue).toArray();
  }

  static int bin1(final int num) {
    int cnt = 0;
    int n = num;
    while (n > 0) {
      cnt += n & 1;
      n >>= 1;
    }
    return cnt;
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      String strNums = scanner.nextLine();
      int[] nums = Stream.of(strNums.split("\\s+")).mapToInt(Integer::parseInt).toArray();
      System.out.println(Arrays.toString(rearrange(nums)));
    }
  }
}
