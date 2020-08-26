package linkedin;

/**
 * LinkedIn OA 2018-2019: Can You Sort
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class CanYouSort {

  private static final Scanner scanner = new Scanner(System.in);

  static void customSort(int[] nums) {
    // Count the frequency
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    // Build bucket
    List<List<Integer>> bucket = new ArrayList<>(nums.length + 1);
    for (int i = 0; i < nums.length + 1; i++) {
      bucket.add(new ArrayList<>());
    }
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      bucket.get(e.getValue()).add(e.getKey());
    }
    // Rebuild array
    int idx = 0;
    for (int cnt = 1; cnt < bucket.size(); cnt++) {
      List<Integer> l = bucket.get(cnt);
      if (l.size() < 1) {
        continue;
      }
      Collections.sort(l);
      for (int n : l) {
        for (int i = 0; i < cnt; i++) {
          nums[idx++] = n;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      String strNums = scanner.nextLine();
      int[] nums = Stream.of(strNums.split("\\s+")).mapToInt(Integer::parseInt).toArray();
      customSort(nums);
      System.out.println(Arrays.toString(nums));
    }
  }
}
