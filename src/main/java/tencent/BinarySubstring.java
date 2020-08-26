package tencent;

/**
 * Tencent OA 2018-2019: Binary Substring
 *
 * @author Yifan Gu
 */
import java.util.Scanner;

public class BinarySubstring { // 90% OOT

  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    if (sc.hasNext()) {
      int k = Integer.valueOf(sc.nextLine());
      String str = sc.nextLine();
      System.out.println(validSubstring(str, k));
    }
    sc.close();
  }

  public static int validSubstring(String str, int k) {
    if (k > str.length()) {
      return 0;
    }
    int count = 0;
    int left = 0;
    int right = 0;
    while (right < str.length()) {
      int cnt = 0;
      int tmpCount = 0;
      while (cnt < k && right < str.length()) {
        cnt += (str.charAt(right++) == '1') ? 1 : 0;
      }
      if (cnt < k) {
        break;
      } else if (cnt == k) {
        tmpCount++;
        while (right < str.length() && str.charAt(right) == '0') {
          tmpCount++;
          right++;
        }
        int t = tmpCount;
        while (str.charAt(left) == '0') {
          tmpCount += t;
          left++;
        }
      }
      left++;
      right = left;
      count += tmpCount;
    }
    return count;
  }
}
