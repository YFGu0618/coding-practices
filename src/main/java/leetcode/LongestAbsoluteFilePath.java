package leetcode;

/**
 * LeetCode Solution No.0388.
 *
 * @see <a href="LongestAbsoluteFilePath">https://leetcode.com/problems/longest-absolute-file-path
 *     </a>
 * @author Yifan Gu
 */
public class LongestAbsoluteFilePath {
  public static int lengthLongestPath(String input) {
    if (input.length() < 1) {
      return 0;
    }
    String[] paths = input.split("\n");
    int[] levels = new int[paths.length + 1];
    int max = 0;
    for (String path : paths) {
      int level = path.lastIndexOf("\t") + 1;
      levels[level + 1] = levels[level] + path.length() - level + 1;
      if (path.contains(".")) {
        max = Math.max(max, levels[level + 1] - 1);
      }
    }
    return max;
  }
}
