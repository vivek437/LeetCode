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
    public List<Integer> largestValues(TreeNode root) {   
        
          List<Integer> ans = new ArrayList<>();
          if(root == null)
              return ans;
          Queue<TreeNode> q1 = new LinkedList<TreeNode>();
          Queue<TreeNode> q2 = new LinkedList<TreeNode>();
          q2.add(root);
          int max = 0;
          while(true){
              max =  Integer.MIN_VALUE;
              while(!q2.isEmpty()){
                 TreeNode temp = q2.poll();
            
                 if(temp.left != null)
                    q1.add(temp.left);
               
                 if(temp.right != null)
                    q1.add(temp.right);
                 
                  if(temp.val > max)
                     max = temp.val;
                  
              }
              ans.add(max);
              q2 = q1;
              q1 = new LinkedList<TreeNode>();
              if(q2.isEmpty())
                  break;
          }
        return ans;
    }
    
}