package leetcode;

/**
 * LeetCode Solution No.0022.
 *
 * @see <a href="GenerateParentheses">https://leetcode.com/problems/generate-parentheses </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
  public static List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    char[] str = new char[2 * n];
    backtrack(result, str, n, n, 0);
    return result;
  }

  public static void backtrack(List<String> list, char[] str, int open, int close, int idx) {
    if (open < 0 || open > close) {
      return;
    }
    if (open == 0 && close == 0) {
      list.add(String.copyValueOf(str));
    } else {
      str[idx] = '(';
      backtrack(list, str, open - 1, close, idx + 1);
      str[idx] = ')';
      backtrack(list, str, open, close - 1, idx + 1);
    }
  }
}
