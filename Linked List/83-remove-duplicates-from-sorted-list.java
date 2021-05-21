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
    public ListNode deleteDuplicates(ListNode head) {
     
          if(head == null)
              return null;
          ListNode temp = head,tempAhead = head.next;
         
          while(tempAhead!=null){
                
              if(tempAhead.val == temp.val)
                  temp.next = tempAhead.next; 
              else
                  temp = temp.next;
              tempAhead = tempAhead.next; 
          }
          
          return head;
    }
}