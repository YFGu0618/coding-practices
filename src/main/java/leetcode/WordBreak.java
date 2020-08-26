package leetcode;

/**
 * LeetCode Solution No.0139.
 *
 * @see <a href="WordBreak">https://leetcode.com/problems/word-break </a>
 * @author Yifan Gu
 */
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
  public static boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>();
    for (String word : wordDict) {
      dict.add(word);
    }
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int end = 1; end <= s.length(); end++) {
      for (int start = 0; start < end; start++) {
        if (dp[start] && dict.contains(s.substring(start, end))) {
          dp[end] = true; // 'end' is pointing to the start of next potential word
          break;
        }
      }
    }
    return dp[dp.length - 1];
  }
}
