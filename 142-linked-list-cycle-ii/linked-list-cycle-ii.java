/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        Boolean d=false;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                d=true;
                break;
            }
        }
        if(d==false){
            return null;
        }
        fast=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}