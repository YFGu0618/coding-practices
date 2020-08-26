package leetcode;

/**
 * LeetCode Solution No.0014.
 *
 * @see <a href="LongestCommonPrefix">https://leetcode.com/problems/longest-common-prefix </a>
 * @author Yifan Gu
 */
public class LongestCommonPrefix {
  public static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    } else if (strs.length == 1) {
      return strs[0];
    }
    // Find out the minimum length of all strings
    int minLen = Integer.MAX_VALUE;
    for (String str : strs) {
      minLen = Math.min(minLen, str.length());
    }
    // Check for the longest prefix that could match
    int stopAt = -1;
    for (int i = 0; i < minLen; i++) {
      char ch = strs[0].charAt(i);
      for (String str : strs) {
        if (str.charAt(i) != ch) {
          return strs[0].substring(0, stopAt + 1);
        }
      }
      stopAt = i;
    }
    return strs[0].substring(0, stopAt + 1);
  }
}
