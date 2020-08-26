package leetcode;

/**
 * LeetCode Solution No.0023.
 *
 * @see <a href="MergeKSortedList">https://leetcode.com/problems/merge-k-sorted-lists </a>
 * @author Yifan Gu
 */
import java.util.Comparator;
import java.util.PriorityQueue;
import leetcode.models.ListNode;

public class MergeKSortedList {
  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> queue =
        new PriorityQueue<ListNode>(
            new Comparator<ListNode>() {
              @Override
              public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
              }
            });
    for (ListNode list : lists) {
      while (list != null) {
        ListNode tmp = list.next;
        list.next = null;
        queue.add(list);
        list = tmp;
      }
    }
    ListNode dummy = new ListNode(0);
    ListNode ptr = queue.poll();
    dummy.next = ptr;
    while (!queue.isEmpty()) {
      ptr.next = queue.poll();
      ptr = ptr.next;
    }
    return dummy.next;
  }
}
