package leetcode;

/**
 * LeetCode Solution No.0049.
 *
 * @see <a href="GroupAnagrams">https://leetcode.com/problems/group-anagrams </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chs = str.toCharArray();
      Arrays.sort(chs);
      String key = String.valueOf(chs);
      List<String> l = map.getOrDefault(key, new ArrayList<>());
      l.add(str);
      map.put(key, l);
    }
    return new ArrayList<List<String>>(map.values());
  }
}
