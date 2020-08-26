package linkedin;

/**
 * LinkedIn OA 2018-2019: Subarray Sum
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class SubarraySum {

  private static final Scanner scanner = new Scanner(System.in);

  static long subarraySum(int[] nums) {
    long result = 0;
    // computing sum of subarray using formula
    for (int i = 0; i < nums.length; i++) {
      result += (nums[i] * (i + 1) * (nums.length - i));
    }
    // return all subarray sum
    return result;
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      String strNums = scanner.nextLine();
      int[] nums = Stream.of(strNums.split("\\s+")).mapToInt(Integer::parseInt).toArray();
      System.out.println(subarraySum(nums));
    }
  }
}
