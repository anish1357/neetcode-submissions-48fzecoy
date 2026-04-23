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
     ListNode ahead = head , behind =head, prev = null;
     n = n-1;
     while(n>0){
        ahead = ahead.next;
        n--;
     }
     while(ahead.next != null){
        ahead = ahead.next;
        prev = behind;
        behind = behind.next;
     }
     if(behind  == head){
        return head.next;
     }
     prev.next = behind.next;
     return head;
    
    }
}
