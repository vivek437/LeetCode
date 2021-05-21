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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        
          return solve(nums,0,nums.length-1);
    }
    
    TreeNode solve(int[] nums,int st,int en){
         
          if(st>en)
              return  null;
        
          int mid = (st + en)/2;
          TreeNode node = new TreeNode(nums[mid]);
          
          node.left = solve(nums,st,mid-1);
          node.right = solve(nums,mid+1,en);
          return node;
    }
}