/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int x;
    
    public int kthSmallest(TreeNode root, int k) {
         x = k;
        return inOrder(root);
    }
       
    int inOrder(TreeNode node){
        
        if(node == null)
           return 0;       
        int l = inOrder(node.left);
           
        x--;
        if (x == 0)
           return node.val;
       
        int r = inOrder(node.right);
        
        if(l == 0 && r == 0)
           return 0;
           
        if(l>r)
           return l;
        else
           return r;
    }
}