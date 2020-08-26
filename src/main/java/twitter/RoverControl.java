package twitter;

/**
 * Twitter OA 2018-2019: Rover Control
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.Scanner;

public class RoverControl {

  private static final Scanner scanner = new Scanner(System.in);

  static int roverMove(int n, String[] cmds) {
    int col = 0;
    int row = 0;
    for (String cmd : cmds) {
      switch (cmd) {
        case "UP":
          if (row > 0) {
            row--;
          }
          break;
        case "DOWN":
          if (row < n - 1) {
            row++;
          }
          break;
        case "LEFT":
          if (col > 0) {
            col--;
          }
          break;
        case "RIGHT":
          if (col < n - 1) {
            col++;
          }
          break;
        default:
          break;
      }
    }
    return (row * n) + col;
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      int n = Integer.valueOf(scanner.nextLine());
      int m = Integer.valueOf(scanner.nextLine());
      String[] cmds = new String[m];
      for (int i = 0; i < m; i++) {
        cmds[i] = scanner.nextLine();
      }
      System.out.println(roverMove(n, cmds));
    }
  }
}
