/*
https://leetcode.com/problems/partition-list/
*/

class Solution {
    public ListNode partition(ListNode head, int x) {
         if(head == null || head.next == null)
                return head;
           ListNode temp = head;
           ListNode prev = null ,part1 = null,part2= null;
           ListNode curr = null;
        
           while(temp!=null){
               
                   if(temp.val>=x){
                     
                       if(curr ==  null){
                           curr = new ListNode(temp.val);
                           part2 = curr;
                       }
                       else{
                            ListNode t = new ListNode(temp.val);
                            curr.next = t;
                            curr = curr.next;
                       }
                   }
                   else{
                        if(prev ==  null){
                           prev = new ListNode(temp.val);
                           part1 = prev;
                       }
                       else{
                           ListNode t = new ListNode(temp.val);
                           prev.next = t;
                           prev = prev.next;    
                       }                     
                   }         
               temp = temp.next;   
           }
           if(prev ==null )
              return part2;
           prev.next = part2;
           return part1;
    }
}
