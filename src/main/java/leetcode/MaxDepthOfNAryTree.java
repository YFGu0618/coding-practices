package leetcode;

/**
 * LeetCode Solution No.0559.
 *
 * @see <a href="MaxDepthOfNAryTree">https://leetcode.com/problems/maximum-depth-of-n-ary-tree </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.List;
import leetcode.models.Node;

public class MaxDepthOfNAryTree {
  public static int maxDepth(Node root) {
    if (root == null) {
      return 0;
    } else {
      return dfs(root, 1);
    }
  }

  public static int dfs(Node node, int level) {
    if (node == null) {
      return 0;
    } else {
      int max = level;
      for (Node child : node.children) {
        max = Math.max(max, dfs(child, level + 1));
      }
      return max;
    }
  }

  public static int bfs(Node root) {
    if (root == null) {
      return 0;
    }
    List<Node> queue = new ArrayList<>();
    queue.add(root);
    int level = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node n = queue.remove(0);
        for (Node child : n.children) {
          queue.add(child);
        }
      }
      level++;
    }
    return level;
  }
}
