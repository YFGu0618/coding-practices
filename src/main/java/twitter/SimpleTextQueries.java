package twitter;

/**
 * Twitter OA 2018-2019: Simple Text Queries
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SimpleTextQueries {

  private static final Scanner scanner = new Scanner(System.in);

  static String textQueries(String[] sentences, String[] queries) {
    // Convert sentenses to posting lists
    Map<String, Set<String>> postings = new HashMap<>();
    for (int i = 0; i < sentences.length; i++) {
      String[] tokens = sentences[i].split("\\s+");
      for (String t : tokens) {
        Set<String> posting = postings.getOrDefault(t, new HashSet<>());
        posting.add(String.valueOf(i));
        postings.put(t, posting);
      }
    }
    System.out.println(postings.toString());
    // Search for queries
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < queries.length; i++) {
      String[] tokens = queries[i].split("\\s+");
      Set<String> set = postings.getOrDefault(tokens[0], new HashSet<>());
      if (set.isEmpty()) {
        sb.append("-1\n");
        continue;
      }
      for (int j = 1; j < tokens.length; j++) {
        set.retainAll(postings.getOrDefault(tokens[j], new HashSet<>()));
      }
      if (set.isEmpty()) {
        sb.append("-1\n");
      } else {
        sb.append(String.join(" ", set) + "\n");
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      int n = Integer.valueOf(scanner.nextLine());
      String[] sentences = new String[n];
      for (int i = 0; i < n; i++) {
        sentences[i] = scanner.nextLine();
      }
      n = Integer.valueOf(scanner.nextLine());
      String[] queries = new String[n];
      for (int i = 0; i < n; i++) {
        queries[i] = scanner.nextLine();
      }
      System.out.println(textQueries(sentences, queries));
    }
  }
}
