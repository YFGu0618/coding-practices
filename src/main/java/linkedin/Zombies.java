package linkedin;

/**
 * LinkedIn OA 2018-2019: Cut The Sticks
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Zombies {

  private static final Scanner scanner = new Scanner(System.in);

  static int zombies(int[][] mat) {
    if (mat == null || mat.length == 0) {
      return 0;
    }
    int n = mat.length;
    int result = 0;
    boolean[] circles = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (mat[i][i] == 1 && !circles[i]) {
        dfs(i, mat, circles);
        result++;
      }
    }
    return result;
  }

  static void dfs(int i, int[][] mat, boolean[] c) {
    if (c[i]) {
      return;
    }
    c[i] = true;
    for (int j = 0; j < mat.length; j++) {
      if (mat[i][j] == 1) {
        dfs(i, mat, c);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      int n = Integer.valueOf(scanner.nextLine());
      int[][] mat = new int[n][n];
      for (int i = 0; i < n; i++) {
        String strNums = scanner.nextLine();
        mat[i] = Stream.of(strNums.split("\\s+")).mapToInt(Integer::parseInt).toArray();
      }
      System.out.println(zombies(mat));
    }
  }
}
