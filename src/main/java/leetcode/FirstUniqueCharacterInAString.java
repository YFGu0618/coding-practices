package leetcode;

/**
 * LeetCode Solution No.0387.
 *
 * @see <a href="FirstUniqueCharacterInAString">
 *     https://leetcode.com/problems/first-unique-character-in-a-string </a>
 * @author Yifan Gu
 */
public class FirstUniqueCharacterInAString {
  public static int firstUniqChar(String s) {
    int[] count = new int[26];
    for (char ch : s.toCharArray()) {
      count[(int) (ch - 'a')]++;
    }
    for (int i = 0; i < s.length(); i++) {
      if (count[(int) (s.charAt(i) - 'a')] == 1) {
        return i;
      }
    }
    return -1;
  }
}
