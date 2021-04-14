/*
https://leetcode.com/problems/deepest-leaves-sum/
*/
class Solution {
    HashMap<Integer,Integer> hm;
    int max=0;
    public int deepestLeavesSum(TreeNode root) {
        
        hm = new HashMap<Integer,Integer>();
        solve(root,1);
        return  hm.get(max);
        
    }
    
    void solve(TreeNode node,int depth){
        
        if(node == null)
            return;
        
        if(depth>max)
             max = depth;
        if(node.right == null && node.left == null)
        {
            if(hm.containsKey(depth))
            {
                 int val = hm.get(depth);
                 val = val + node.val;
                 hm.put(depth,val);
            }
            else
                 hm.put(depth,node.val);
        }
        else{
            if(node.right != null)   
                solve(node.right, depth+1);
            if(node.left != null)
                solve(node.left, depth+1);
        }
                    
    }
}
