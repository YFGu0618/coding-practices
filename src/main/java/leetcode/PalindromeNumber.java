package leetcode;

/**
 * LeetCode Solution No.0009.
 *
 * @see <a href="PalindromeNumber">https://leetcode.com/problems/palindrome-number </a>
 * @author Yifan Gu
 */
public class PalindromeNumber {
  public static boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }
    int num = 0;
    while (num < x) {
      num = num * 10 + x % 10;
      x /= 10;
    }
    if (num != x && num / 10 != x) {
      return false;
    } else {
      return true;
    }
  }
}
