package leetcode;

/**
 * LeetCode Solution No.0003.
 *
 * @see <a href="LongestStringWithoutRepeatingCharacters">
 *     https://leetcode.com/problems/longest-substring-without-repeating-characters </a>
 * @author Yifan Gu
 */
import java.util.Arrays;

public class LongestStringWithoutRepeatingCharacters {
  public static int lengthOfLongestSubstring(String s) {
    if (s == null) {
      return 0;
    } else if (s.length() < 2) {
      return s.length();
    }
    int[] table = new int[256];
    Arrays.fill(table, -1);
    int maxLen = 0;
    int leftIdx = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (table[(int) s.charAt(i)] != -1) {
        leftIdx = Math.max(leftIdx, table[(int) s.charAt(i)] + 1);
      }
      table[(int) s.charAt(i)] = i;
      maxLen = Math.max(maxLen, i - leftIdx + 1);
    }
    return maxLen;
  }
}
