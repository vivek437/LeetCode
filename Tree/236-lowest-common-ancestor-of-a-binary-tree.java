/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         
        solve(root,p.val,q.val);
        return ans;
    }
    
    
    int solve(TreeNode node, int a, int b){
        
        
        if(node == null)
             return 0;
       
        if(ans != null)
             return 0;
        
        int left =   solve(node.left,  a, b);
        int right =  solve(node.right,  a, b);
           
        if(left == 1 && right == 1){
            ans = node;
            return 1;
        }           
        else if((node.val == a||node.val == b) && (left == 1 || right == 1))  {
            ans = node;
            return 1;
        }
        else if(node.val == a || node.val == b)
            return 1;
        else if(left == 1 || right == 1)
            return 1;
        else 
            return 0;
    }
}