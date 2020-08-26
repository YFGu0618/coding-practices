package leetcode;

/**
 * LeetCode Solution No.0647.
 *
 * @see <a href="PalindromicSubstring">https://leetcode.com/problems/palindromic-substrings </a>
 * @author Yifan Gu
 */
public class PalindromicSubstring {
  public static int countSubstrings(String s) {
    if (s == null) {
      return 0;
    } else if (s.length() <= 1) {
      return s.length();
    }
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      count += extend(s, i, i);
      count += extend(s, i, i + 1);
    }
    return count;
  }

  public static int extend(String s, int l, int r) {
    int count = 0;
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      count++;
      l--;
      r++;
    }
    return count;
  }
}
