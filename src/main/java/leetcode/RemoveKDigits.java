package leetcode;

/**
 * LeetCode Solution No.0402.
 *
 * @see <a href="RemoveKDigits">https://leetcode.com/problems/remove-k-digits </a>
 * @author Yifan Gu
 */
public class RemoveKDigits {
  public static String removeKdigits(String num, int k) {
    int len = num.length();
    if (k <= 0) {
      return num;
    } else if (k >= len) {
      return "0";
    }
    // Use char array to simulate a stack with random access
    char[] stack = new char[len];
    int idxTop = 0;
    int leftRm = k;
    for (char ch : num.toCharArray()) {
      while (leftRm > 0 && idxTop > 0 && ch < stack[idxTop - 1]) {
        idxTop--;
        leftRm--;
      }
      stack[idxTop++] = ch;
    }
    // Get rid of the leading '0's
    int start = 0;
    while (start < len && stack[start] == '0') {
      start++;
    }
    // If after removal only left '0's, should return "0" instead of "", fix the problem
    if (len - k - start == 0) {
      start--;
    }
    return new String(stack, start, len - k - start);
  }
}
