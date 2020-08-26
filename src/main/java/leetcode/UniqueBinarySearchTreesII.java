package leetcode;

/**
 * LeetCode Solution No.0095.
 *
 * @see <a href="UniqueBinarySearchTreesII">
 *     https://leetcode.com/problems/unique-binary-search-trees-ii </a>
 * @author Yifan Gu
 */
import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static List<TreeNode> generateTrees(int n) {
    if (n < 1) {
      return new ArrayList<>();
    }
    return gen(1, n);
  }

  public static List<TreeNode> gen(int start, int end) {
    List<TreeNode> result = new ArrayList<>();
    if (start > end) {
      result.add(null);
      return result;
    }
    for (int i = start; i <= end; i++) {
      List<TreeNode> lefts = gen(start, i - 1);
      List<TreeNode> rights = gen(i + 1, end);
      for (TreeNode l : lefts) {
        for (TreeNode r : rights) {
          TreeNode root = new TreeNode(i);
          root.left = l;
          root.right = r;
          result.add(root);
        }
      }
    }
    return result;
  }
}
