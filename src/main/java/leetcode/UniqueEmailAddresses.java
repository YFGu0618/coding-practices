package leetcode;

/**
 * LeetCode Solution No.0929.
 *
 * @see <a href="UniqueEmailAddresses">https://leetcode.com/problems/unique-email-addresses </a>
 * @author Yifan Gu
 */
import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
  public static int numUniqueEmails(String[] emails) {
    Set<String> set = new HashSet<>();
    for (String email : emails) {
      String[] parts = email.split("@");
      String id = parts[0].split("\\+")[0];
      String uid = id.replaceAll("\\.", "");
      set.add(uid + parts[1]);
    }
    return set.size();
  }
}
