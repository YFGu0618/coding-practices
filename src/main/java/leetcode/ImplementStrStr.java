package leetcode;

/**
 * LeetCode Solution No.0028.
 *
 * @see <a href="ImplementStrStr">https://leetcode.com/problems/implement-strstr </a>
 * @author Yifan Gu
 */
public class ImplementStrStr {
  public static int strStr(String haystack, String needle) {
    if (haystack == null || needle == null || needle.length() == 0) {
      return 0;
    } else if (haystack.length() == 0) {
      return -1;
    }
    int[] lps = kmp(needle);
    for (int i = 0, j = 0; i < haystack.length(); ) {
      if (haystack.charAt(i) == needle.charAt(j)) {
        i++;
        j++;
      }
      if (j == needle.length()) {
        return (i - j);
      }
      if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
        if (j > 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }
    return -1;
  }

  public static int[] kmp(String needle) {
    int[] lps = new int[needle.length()];
    for (int i = 1, len = 0; i < needle.length(); ) {
      if (needle.charAt(i) == needle.charAt(len)) {
        lps[i++] = ++len;
      } else if (len > 0) {
        len = lps[len - 1];
      } else {
        lps[i++] = 0;
      }
    }
    return lps;
  }
}
