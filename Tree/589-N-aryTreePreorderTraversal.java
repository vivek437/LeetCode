
/*
https://leetcode.com/problems/n-ary-tree-preorder-traversal/
*/


class Solution {
    List<Integer> ans;
    public List<Integer> preorder(Node root) {
        
         ans = new ArrayList<Integer>();
        solve(root);
        return ans;
    }
    
   void solve(Node node){
          
          if(node== null)
               return;
          
          ans.add(node.val);   
          for(int i = 0; i < node.children.size();i++){
                   solve(node.children.get(i));
          }     
          
         
    }
}
