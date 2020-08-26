package twitter;

/**
 * Twitter OA 2018-2019: Hackerland Election
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class HackerlandElection {

  private static final Scanner scanner = new Scanner(System.in);

  static String electionWinner(String[] votes) {
    Map<String, Integer> map = new HashMap<>();
    for (String n : votes) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
    String winner = "";
    int maxVote = Integer.MIN_VALUE;
    for (Entry<String, Integer> e : map.entrySet()) {
      String name = e.getKey();
      int vote = e.getValue();
      if (vote > maxVote) {
        winner = name;
        maxVote = vote;
      } else if (vote == maxVote && (name.compareTo(winner) > 0)) {
        winner = name;
      }
    }
    return winner;
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      int votes = Integer.valueOf(scanner.nextLine());
      String[] names = new String[votes];
      for (int i = 0; i < votes; i++) {
        names[i] = scanner.nextLine();
      }
      System.out.println(electionWinner(names));
    }
  }
}
