package leetcode;

/**
 * LeetCode Solution No.0773.
 *
 * @see <a href="SlidingPuzzle">https://leetcode.com/problems/sliding-puzzle </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SlidingPuzzle {
  public static int slidingPuzzle(int[][] board) {
    String target = "123450";
    int[] moves = new int[] {1, -1, 3, -3};
    int result = 0;
    StringBuilder bd = new StringBuilder();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        bd.append(board[i][j]);
      }
    }
    List<String> queue = new ArrayList<>();
    Set<String> set = new HashSet<>();
    queue.add(bd.toString());
    set.add(bd.toString());
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String str = queue.remove(0);
        if (str.equals(target)) {
          return result;
        }
        int pos0 = str.indexOf('0');
        for (int move : moves) {
          if (pos0 == 2 && move == 1 || pos0 == 3 && move == -1) {
            continue;
          }
          String candidate = moveChar(str, pos0, move);
          if (candidate != null && !set.contains(candidate)) {
            queue.add(candidate);
            set.add(candidate);
          }
        }
      }
      result++;
    }
    return -1;
  }

  public static String moveChar(String str, int pos, int move) {
    int dest = pos + move;
    if (dest < 0 || dest >= str.length()) {
      return null;
    }
    StringBuilder sb = new StringBuilder(str);
    char tmp = str.charAt(dest);
    sb.setCharAt(dest, str.charAt(pos));
    sb.setCharAt(pos, tmp);
    return sb.toString();
  }
}
