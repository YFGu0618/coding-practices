package leetcode;

/**
 * LeetCode Solution No.0005.
 *
 * @see <a href="LongestPalindromicSubstring">
 *     https://leetcode.com/problems/longest-palindromic-substring </a>
 * @author Yifan Gu
 */
public class LongestPalindromicSubstring {
  public static String longestPalindrome(String s) {
    if (s == null) {
      return "";
    } else if (s.length() <= 1) {
      return s;
    }
    return longest(s);
  }

  public static String longest(String s) {
    int start = 0;
    int maxLen = 0;
    for (int i = 0; i < s.length(); i++) {
      int left = i;
      int right = i;
      while (right + 1 < s.length() && s.charAt(right) == s.charAt(right + 1)) {
        right++;
        i = right;
      }
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
      }
      if (right - left - 1 > maxLen) {
        maxLen = right - left - 1;
        start = left + 1;
      }
    }
    return s.substring(start, start + maxLen);
  }
}
