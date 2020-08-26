package leetcode;

/**
 * LeetCode Solution No.0685.
 *
 * @see <a href="RedundantConnectionII">https://leetcode.com/problems/redundant-connection-ii </a>
 * @author Yifan Gu
 */
public class RedundantConnectionII {
  public static int[] findRedundantDirectedConnection(int[][] edges) {
    int[] parent = new int[1001];
    int[] res1 = {-1, -1};
    int[] res2 = {-1, -1};
    // Find if any child node has two parents
    for (int i = 0; i < edges.length; i++) {
      int p = edges[i][0];
      int c = edges[i][1];
      if (parent[c] == 0) {
        parent[c] = p;
      } else {
        // Previously seen edge for child c
        res1 = new int[] {parent[c], c};
        // Currently invalid edge for child c
        res2 = new int[] {p, c};
        // Mark the edge as invalid by setting child to 0
        edges[i][1] = 0;
      }
    }
    // Start regular union find
    for (int i = 0; i < edges.length; i++) {
      parent[i] = i;
    }
    int[] res = new int[2];
    for (int i = 0; i < edges.length; i++) {
      int p = edges[i][0];
      int c = edges[i][1];
      if (c == 0) {
        continue;
      }
      // If tracing up for p lead to child c, meaning there is a loop
      if (check(parent, p) == c) {
        if (res1[0] == -1) {
          res = edges[i];
        } else {
          return res1;
        }
      }
      parent[c] = p;
    }
    return (res1[0] == -1) ? res : res2;
  }

  public static int check(int[] parent, int i) {
    while (i != parent[i]) {
      parent[i] = parent[parent[i]];
      i = parent[i];
    }
    return i;
  }
}
