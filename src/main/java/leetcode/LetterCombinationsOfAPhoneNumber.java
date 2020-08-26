package leetcode;

/**
 * LeetCode Solution No.0017.
 *
 * @see <a href="LetterCombinationsOfAPhoneNumber">
 *     https://leetcode.com/problems/letter-combinations-of-a-phone-number </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
  public static List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits.length() < 1) {
      return result;
    }
    char[] str = new char[digits.length()];
    backtrack(result, str, digits, 0, 0);
    return result;
  }

  public static void backtrack(List<String> list, char[] str, String digits, int d, int idx) {
    if (d >= digits.length()) {
      list.add(String.copyValueOf(str));
      return;
    } else {
      switch (digits.charAt(d)) {
        case '2':
          for (char c : new char[] {'a', 'b', 'c'}) {
            str[idx] = c;
            backtrack(list, str, digits, d + 1, idx + 1);
          }
          break;
        case '3':
          for (char c : new char[] {'d', 'e', 'f'}) {
            str[idx] = c;
            backtrack(list, str, digits, d + 1, idx + 1);
          }
          break;
        case '4':
          for (char c : new char[] {'g', 'h', 'i'}) {
            str[idx] = c;
            backtrack(list, str, digits, d + 1, idx + 1);
          }
          break;
        case '5':
          for (char c : new char[] {'j', 'k', 'l'}) {
            str[idx] = c;
            backtrack(list, str, digits, d + 1, idx + 1);
          }
          break;
        case '6':
          for (char c : new char[] {'m', 'n', 'o'}) {
            str[idx] = c;
            backtrack(list, str, digits, d + 1, idx + 1);
          }
          break;
        case '7':
          for (char c : new char[] {'p', 'q', 'r', 's'}) {
            str[idx] = c;
            backtrack(list, str, digits, d + 1, idx + 1);
          }
          break;
        case '8':
          for (char c : new char[] {'t', 'u', 'v'}) {
            str[idx] = c;
            backtrack(list, str, digits, d + 1, idx + 1);
          }
          break;
        case '9':
          for (char c : new char[] {'w', 'x', 'y', 'z'}) {
            str[idx] = c;
            backtrack(list, str, digits, d + 1, idx + 1);
          }
          break;
      }
    }
  }
}
