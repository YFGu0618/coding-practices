package leetcode;

/**
 * LeetCode Solution No.0102.
 *
 * @see <a href="BinaryTreeLevelOrderTraversal">
 *     https://leetcode.com/problems/binary-tree-level-order-traversal </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.List;
import leetcode.models.TreeNode;

public class BinaryTreeLevelOrderTraversal {
  public static List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<TreeNode> queue = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> row = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode n = queue.remove(0);
        row.add(n.val);
        if (n.left != null) {
          queue.add(n.left);
        }
        if (n.right != null) {
          queue.add(n.right);
        }
      }
      result.add(row);
    }
    return result;
  }
}
