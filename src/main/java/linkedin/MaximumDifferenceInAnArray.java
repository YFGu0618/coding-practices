package linkedin;

/**
 * LinkedIn OA 2018-2019: Maximum Difference in an Array
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class MaximumDifferenceInAnArray {

  private static final Scanner scanner = new Scanner(System.in);

  static int maxDifference(int[] nums) {
    int maxDiff = nums[1] - nums[0];
    int min = nums[0];
    for (int i = 1; i < nums.length; i++) {
      maxDiff = Math.max(maxDiff, nums[i] - min);
      min = Math.min(min, nums[i]);
    }
    return maxDiff;
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      String strNums = scanner.nextLine();
      int[] nums = Stream.of(strNums.split("\\s+")).mapToInt(Integer::parseInt).toArray();
      System.out.println(maxDifference(nums));
    }
  }
}
