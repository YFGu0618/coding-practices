package leetcode;

/**
 * LeetCode Solution No.0019.
 *
 * @see <a href="RemoveNthNodeFromEndOfList">
 *     https://leetcode.com/problems/remove-nth-node-from-end-of-list </a>
 * @author Yifan Gu
 */
import leetcode.models.ListNode;

public class RemoveNthNodeFromEndOfList {
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    // If only one node in the list
    if (head.next == null) {
      return null;
    }
    // Dummy head is always pointing to actual head of the list
    // Used to handle the case that the original head is to be removed
    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    dummy.next = head;
    // Two pointers, fast is n ahead of slow
    ListNode slow = dummy;
    ListNode fast = dummy;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    // Remove the next node of slow
    slow.next = slow.next.next;
    // Return the actual head after removal
    return dummy.next;
  }
}
