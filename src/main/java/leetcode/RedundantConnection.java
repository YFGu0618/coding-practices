package leetcode;

/**
 * LeetCode Solution No.0684.
 *
 * @see <a href="RedundantConnection">https://leetcode.com/problems/redundant-connection </a>
 * @author Yifan Gu
 */
public class RedundantConnection {
  public static int[] findRedundantConnection(int[][] edges) {
    int[] parent = new int[1001];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }
    int[] res = new int[2];
    for (int[] e : edges) {
      int v1 = e[0];
      int v2 = e[1];
      if (check(parent, v1) == check(parent, v2)) {
        res = e;
      } else {
        parent[check(parent, v1)] = check(parent, v2);
      }
    }
    return res;
  }

  public static int check(int[] parent, int v) {
    while (v != parent[v]) {
      parent[v] = parent[parent[v]];
      v = parent[v];
    }
    return v;
  }
}
