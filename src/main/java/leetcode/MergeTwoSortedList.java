package leetcode;

/**
 * LeetCode Solution No.0021.
 *
 * @see <a href="MergeTwoSortedList">https://leetcode.com/problems/merge-two-sorted-lists </a>
 * @author Yifan Gu
 */
import leetcode.models.ListNode;

public class MergeTwoSortedList {
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode ptr = dummy;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        ptr.next = l2;
        break;
      } else if (l2 == null) {
        ptr.next = l1;
        break;
      }
      if (l1.val < l2.val) {
        ptr.next = l1;
        l1 = l1.next;
      } else {
        ptr.next = l2;
        l2 = l2.next;
      }
      ptr = ptr.next;
    }
    return dummy.next;
  }
}
