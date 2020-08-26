package leetcode;

/**
 * LeetCode Solution No.0025.
 *
 * @see <a href="ReverseNodesInKGroups">https://leetcode.com/problems/reverse-nodes-in-k-group </a>
 * @author Yifan Gu
 */
import leetcode.models.ListNode;

public class ReverseNodesInKGroups {
  public static ListNode reverseKGroup(ListNode head, int k) {
    // Count the length of the list
    if (head == null || k < 2) {
      return head;
    }
    int len = 0;
    ListNode ptr0 = head;
    while (ptr0 != null) {
      ptr0 = ptr0.next;
      len++;
    }
    if (len < k) {
      return head;
    }
    // Start reversing the list
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ptr0 = dummy;
    ListNode ptr1 = dummy.next;
    for (int i = 0; i < len / k; i++) {
      for (int j = 0; j < k - 1; j++) { // k nodes only have k-1 links
        ListNode tmp = ptr1.next;
        ptr1.next = tmp.next;
        tmp.next = ptr0.next;
        ptr0.next = tmp;
      }
      ptr0 = ptr1;
      ptr1 = ptr0.next;
    }
    return dummy.next;
  }
}
