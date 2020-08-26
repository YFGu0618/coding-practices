package leetcode;

/**
 * LeetCode Solution No.0002.
 *
 * @see <a href="AddTwoNumbers">https://leetcode.com/problems/add-two-numbers </a>
 * @author Yifan Gu
 */
import leetcode.models.ListNode;

public class AddTwoNumbers {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode currentL1 = l1;
    ListNode currentL2 = l2;
    ListNode result = new ListNode(0);
    ListNode head = result;
    int carry = 0;
    int sum = 0;
    while (currentL1 != null || currentL2 != null) {
      if (currentL1 != null && currentL2 != null) {
        sum = currentL1.val + currentL2.val + carry;
      } else if (currentL1 != null) {
        sum = currentL1.val + carry;
      } else {
        sum = currentL2.val + carry;
      }
      if (sum > 9) {
        carry = 1;
        sum = sum - 10;
      } else {
        carry = 0;
      }
      result.next = new ListNode(sum);
      result = result.next;
      if (currentL1 != null) {
        currentL1 = currentL1.next;
      }
      if (currentL2 != null) {
        currentL2 = currentL2.next;
      }
    }
    if (carry == 1) {
      result.next = new ListNode(1);
    }
    return head.next;
  }
}
