/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);

        add(l1, l2, dummy, 0);

        return dummy.next;
    }

    public void add(ListNode l1, ListNode l2, ListNode dummy, int carry) {
        if(l1 == null && l2 == null && carry == 0) return;

        int v1 = l1 != null ? l1.val : 0;
        int v2 = l2 != null ? l2.val : 0;

        int sum = v1 + v2 + carry;
        int value = sum % 10;
        carry = sum / 10;
        
        dummy.next = new ListNode(value);
        dummy = dummy.next;
        
        if(l1 != null) l1 = l1.next;
        if(l2 != null) l2 = l2.next;

        add(l1, l2, dummy, carry);
    }
}
