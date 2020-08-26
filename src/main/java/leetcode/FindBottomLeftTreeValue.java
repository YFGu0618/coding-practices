package leetcode;

/**
 * LeetCode Solution No.0513.
 *
 * @see <a href="FindBottomLeftTreeValue">https://leetcode.com/problems/find-bottom-left-tree-value
 *     </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.List;
import leetcode.models.TreeNode;

public class FindBottomLeftTreeValue {
  public static int findBottomLeftValue(TreeNode root) {
    if (root == null) {
      return -1;
    }
    List<TreeNode> queue = new ArrayList<>();
    queue.add(root);
    int leftVal = root.val;
    while (!queue.isEmpty()) {
      int size = queue.size();
      leftVal = queue.get(0).val;
      for (int i = 0; i < size; i++) {
        TreeNode n = queue.remove(0);
        if (n.left != null) {
          queue.add(n.left);
        }
        if (n.right != null) {
          queue.add(n.right);
        }
      }
    }
    return leftVal;
  }
}
