package twitter;

/**
 * Twitter OA 2018-2019: Image Matching
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImageMatching {

  private static final Scanner scanner = new Scanner(System.in);

  public static class Point {
    int r = 0;
    int c = 0;

    public Point(int r, int c) {
      this.r = r;
      this.c = c;
    }

    @Override
    public boolean equals(Object p) {
      if (p == null || p.getClass() != this.getClass()) {
        return false;
      } else if (this == p) {
        return true;
      } else {
        Point point = (Point) p;
        return (point.r == this.r && point.c == this.c);
      }
    }

    @Override
    public String toString() {
      return "<" + this.r + "," + this.c + ">";
    }
  }

  public static int countMatches(List<String> grid1, List<String> grid2) {
    // Write your code here
    // Initialize flags
    int rows = grid1.size();
    int cols = grid1.get(0).length();
    boolean[][] checked1 = new boolean[rows][cols];
    boolean[][] checked2 = new boolean[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        checked1[i][j] = false;
        checked2[i][j] = false;
      }
    }
    // Start comparing
    int matches = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        List<Point> regions1 = findRegions(grid1, r, c, checked1);
        List<Point> regions2 = findRegions(grid2, r, c, checked2);
        if (!regions1.isEmpty() && !regions2.isEmpty()) {
          matches += regions1.equals(regions2) ? 1 : 0;
        }
      }
    }
    return matches;
  }

  public static List<Point> findRegions(List<String> grid, int r, int c, boolean[][] checked) {
    List<Point> regions = new ArrayList<>();
    if (checked[r][c]) {
      return regions;
    } else if (grid.get(r).charAt(c) == '0') {
      return regions;
    }
    int rows = grid.size();
    int cols = grid.get(0).length();
    List<Point> queue = new ArrayList<>();
    Point p0 = new Point(r, c);
    queue.add(p0);
    while (!queue.isEmpty()) {
      Point p = queue.remove(0);
      checked[p.r][p.c] = true;
      regions.add(p);
      // 1 row up
      if (p.r - 1 >= 0
          && p.c < cols
          && !checked[p.r - 1][p.c]
          && grid.get(p.r - 1).charAt(p.c) == '1') {
        Point p1 = new Point(p.r - 1, p.c);
        queue.add(p1);
      }
      // 1 row down
      if (p.r + 1 < rows
          && p.c < cols
          && !checked[p.r + 1][p.c]
          && grid.get(p.r + 1).charAt(p.c) == '1') {
        Point p1 = new Point(p.r + 1, p.c);
        queue.add(p1);
      }
      // 1 col left
      if (p.r < rows
          && p.c - 1 >= 0
          && !checked[p.r][p.c - 1]
          && grid.get(p.r).charAt(p.c - 1) == '1') {
        Point p1 = new Point(p.r, p.c - 1);
        queue.add(p1);
      }
      // 1 col right
      if (p.r < rows
          && p.c + 1 < cols
          && !checked[p.r][p.c + 1]
          && grid.get(p.r).charAt(p.c + 1) == '1') {
        Point p1 = new Point(p.r, p.c + 1);
        queue.add(p1);
      }
    }
    if (regions.size() == 1) {
      Point p = regions.get(0);
      if (grid.get(p.r).charAt(p.c) == '0') {
        return new ArrayList<>();
      }
    }
    return regions;
  }

  public static void main(String[] args) throws IOException {
    while (scanner.hasNext()) {
      int n = Integer.valueOf(scanner.nextLine());
      List<String> grid1 = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        grid1.add(scanner.nextLine());
      }
      n = Integer.valueOf(scanner.nextLine());
      List<String> grid2 = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        grid2.add(scanner.nextLine());
      }
      System.out.println(countMatches(grid1, grid2));
    }
  }
}
