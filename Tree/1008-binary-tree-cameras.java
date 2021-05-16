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
    int cam;
    public int minCameraCover(TreeNode root) {
       
        int x = dfs(root);
        return x == 0 ? cam+1:cam;
    }
    
    // 2 - Has Camera 
    // 1 - Covered With Camera
    // 0 - Not Covered
    int dfs(TreeNode node){
        
       
        if( node == null ) return 1;
        
      
        int left = dfs(node.left);
        int right = dfs(node.right);
        System.out.println(left+" "+right);
        if(left == 0 || right == 0)
        {
            cam++;
            return 2;
        }
        if(left == 2 || right == 2)
            return 1;
        else
            return 0;
                
    }
}


         