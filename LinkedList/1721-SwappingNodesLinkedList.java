/*
https://leetcode.com/problems/swapping-nodes-in-a-linked-list/submissions/
*/

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        
            ListNode frontK = head,lastK = head;
            int c = 0;
            ListNode temp = head;

            while(temp != null){
                 c++;
                 if(c>k){
                     lastK = lastK.next;
                 }
                 else if(c<k)
                     frontK = frontK.next;
   
                temp = temp.next;
            }
         int x = frontK.val;
         frontK.val = lastK.val;
         lastK.val = x;
         return head;
    }
}
