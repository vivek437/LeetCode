/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
         ListNode temp = new ListNode(head.val,head.next);
         head = temp;
         ListNode prev = temp;
         int c=0;
         while(temp!=null){
             c++;
             if(c>n+1){
                prev = prev.next; 
             }    
             temp = temp.next;
         }
      
         if(c==n)
          return head.next;
         else{
               prev.next = prev.next.next;
            return head;
         }
    }
}
