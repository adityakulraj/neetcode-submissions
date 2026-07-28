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
    public boolean isPalindrome(ListNode head) {

        if(head==null)
        return false;

        if(head.next==null)
        return true;

        if(head.next.next == null)
        return head.val == head.next.val;

        ListNode slow = head;

        ListNode fast = head;

        while(fast!=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        

        ListNode revHead = slow;
        ListNode prev = null;
        ListNode curr = revHead;

        while(curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;

        }


        ListNode h1 = head;
        ListNode h2 = prev;


        while(h2!=null) {
            if(h1.val != h2.val)
             return false;

             h1 = h1.next;
             h2 = h2.next;
        }

        return true;
        
    }
}