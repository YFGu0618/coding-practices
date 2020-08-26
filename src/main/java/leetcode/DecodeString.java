package leetcode;

/**
 * LeetCode Solution No.0394.
 *
 * @see <a href="DecodeString">https://leetcode.com/problems/decode-string </a>
 * @author Yifan Gu
 */
import java.util.Stack;

public class DecodeString {
  public static String decodeString(String s) {
    StringBuilder res = new StringBuilder();
    Stack<Integer> repeats = new Stack<>();
    Stack<StringBuilder> segments = new Stack<>();
    int i = 0;
    while (i < s.length()) {
      if (Character.isDigit(s.charAt(i))) {
        int count = 0;
        while (Character.isDigit(s.charAt(i))) {
          count = 10 * count + (s.charAt(i) - '0');
          i++;
        }
        repeats.push(count);
      } else if (s.charAt(i) == '[') {
        segments.push(res);
        res = new StringBuilder();
        i++;
      } else if (s.charAt(i) == ']') {
        StringBuilder sb = new StringBuilder(segments.pop());
        int rep = repeats.pop();
        for (int j = 0; j < rep; j++) {
          sb.append(res);
        }
        res = sb;
        i++;
      } else {
        res.append(s.charAt(i++));
      }
    }
    return res.toString();
  }
}
