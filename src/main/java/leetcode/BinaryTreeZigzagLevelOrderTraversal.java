package leetcode;

/**
 * LeetCode Solution No.0103.
 *
 * @see <a href="BinaryTreeZigzagLevelOrderTraversal">
 *     https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.List;
import leetcode.models.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    int level = 0;
    List<TreeNode> queue = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> row = new ArrayList<>();
      int size = queue.size();
      if (level % 2 == 0) {
        for (int i = 0; i < size; i++) {
          row.add(queue.get(i).val);
        }
      } else {
        for (int i = size - 1; i >= 0; i--) {
          row.add(queue.get(i).val);
        }
      }
      result.add(row);
      for (int i = 0; i < size; i++) {
        TreeNode n = queue.remove(0);
        if (n.left != null) {
          queue.add(n.left);
        }
        if (n.right != null) {
          queue.add(n.right);
        }
      }
      level++;
    }
    return result;
  }
}
