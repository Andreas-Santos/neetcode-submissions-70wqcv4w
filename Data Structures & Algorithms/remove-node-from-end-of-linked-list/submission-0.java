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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // [1, 2, 3, 4]
        //  ^  ^  ^  ^
        //  4  3  2  1
        // n = 4;
        // so i need to delete the number 3 from the linkedlist

        // [1, 2, 3, 4]
        // fast = head
        // slow = head
        // fast go till n position (from 1), for = to n
        // fast sits at 3
        // slow starts moving 
        // slow gets to 2
        // slow.next = slow.next.next 

        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;

        while(n > 0) {
            fast = fast.next;
            n--;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
