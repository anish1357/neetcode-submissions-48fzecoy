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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null){
            if(list1 == null && list2 == null){
                return null;
            }
            return list1 == null ? list2 :list1;
        }
        if(list1.val > list2.val){
            return mergeTwoLists(list2,list1);
        }
        ListNode p1 = list1 ,  p2 = list2 , h = new ListNode();
        ListNode t = h ;
        while(p1 != null || p2 != null){
            if(p1 != null && p2 != null){
              if(p1.val <= p2.val){
                t.next = p1;
                p1 = p1.next;
              }else {
                t.next =  p2 ;
                p2 = p2.next;
              }
              t = t.next;
            }
            if(p1 == null){
                t.next = p2;
                break;
            }
            if(p2 == null){
                t.next = p1;
                break;
            }
        }
        return h.next;
    }
}