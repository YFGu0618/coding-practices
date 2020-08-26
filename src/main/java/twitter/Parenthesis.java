package twitter;

/**
 * Twitter OA 2018-2019: Parenthesis
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Parenthesis {

  private static final Scanner scanner = new Scanner(System.in);

  static String[] braces(String[] strs) {
    String[] result = new String[strs.length];
    for (int i = 0; i < strs.length; i++) {
      for (String str : strs) {
        if (validate(str)) {
          result[i] = "YES";
        } else {
          result[i] = "NO";
        }
      }
    }
    return result;
  }

  static boolean validate(String str) {
    Stack<Character> stack = new Stack<>();
    for (char ch : str.toCharArray()) {
      if (ch == '(' || ch == '{' || ch == '[') {
        stack.push(ch);
      } else if (stack.isEmpty()) {
        return false;
      } else if (ch == ')' && stack.peek() == '('
          || ch == '}' && stack.peek() == '{'
          || ch == ']' && stack.peek() == '[') {
        stack.pop();
      } else {
        stack.push(ch);
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      int n = Integer.valueOf(scanner.nextLine());
      String[] strs = new String[n];
      for (int i = 0; i < n; i++) {
        strs[i] = scanner.nextLine();
      }
      System.out.println(Arrays.toString(braces(strs)));
    }
  }
}
