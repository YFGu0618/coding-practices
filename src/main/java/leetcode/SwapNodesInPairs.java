package leetcode;

/**
 * LeetCode Solution No.0024.
 *
 * @see <a href="SwapNodesInPairs">https://leetcode.com/problems/swap-nodes-in-pairs </a>
 * @author Yifan Gu
 */
import leetcode.models.ListNode;

public class SwapNodesInPairs {
  public static ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode ptr = dummy;
    while (ptr.next != null) {
      if (ptr.next.next != null) {
        ListNode tmp = ptr.next;
        ptr.next = tmp.next;
        tmp.next = ptr.next.next;
        ptr.next.next = tmp;
        ptr = tmp;
      } else {
        break;
      }
    }
    return dummy.next;
  }
}
