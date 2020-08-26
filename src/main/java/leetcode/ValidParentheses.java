package leetcode;

/**
 * LeetCode Solution No.0020.
 *
 * @see <a href="ValidParentheses">https://leetcode.com/problems/valid-parentheses </a>
 * @author Yifan Gu
 */
import java.util.Stack;

public class ValidParentheses {
  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      try {
        if (c == '(' || c == '{' || c == '[') {
          stack.push(c);
        } else if (c == ')' && stack.peek() == '('
            || c == '}' && stack.peek() == '{'
            || c == ']' && stack.peek() == '[') {
          stack.pop();
        } else {
          return false;
        }
      } catch (Exception ese) {
        return false;
      }
    }
    return stack.isEmpty();
  }
}
