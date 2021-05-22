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
    HashSet<Integer> hs = new HashSet<Integer>();
    public boolean findTarget(TreeNode root, int k) {      
          return inOrder(root,k);
    }
    
    boolean inOrder(TreeNode node,int target)
    {
           if(node == null)
             return false;
             
           if(inOrder(node.left,target))
              return true;

           int p = node.val;
           if(hs.contains(target-p))
               return true;
  
           hs.add(node.val);
           if(inOrder(node.right,target))
               return true;
           
           return false;
    }
}