package linkedin;

/**
 * LinkedIn OA 2018-2019: Minimum Unique Array Sum
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class MinimumUniqueArraySum {

  private static final Scanner scanner = new Scanner(System.in);

  static int getMinimumUniqueSum(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] <= nums[i - 1]) {
        nums[i] = nums[i - 1] + 1;
      }
    }
    return Arrays.stream(nums).sum();
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      String strNums = scanner.nextLine();
      int[] nums = Stream.of(strNums.split("\\s+")).mapToInt(Integer::parseInt).toArray();
      System.out.println(getMinimumUniqueSum(nums));
      System.out.println(Arrays.toString(nums));
    }
  }
}
