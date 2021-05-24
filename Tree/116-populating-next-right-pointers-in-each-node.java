/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        
          if(root ==  null)
              return null;
          Queue<Node> q1 = new LinkedList<Node>();
          Queue<Node> q2 = new LinkedList<Node>();
          q2.add(root);
        
          while(true){
            
             Node par = q2.poll();
             if(par.left!= null)
                    q1.add(par.left);
                
             if(par.right!= null)
                    q1.add(par.right);
              
              while(!q2.isEmpty()) {
                
                Node temp = q2.poll();
             
                 if(temp.left!= null)
                    q1.add(temp.left);
                
                 if(temp.right!= null)
                    q1.add(temp.right); 
                
                par.next = temp;
                par = temp;
             }  
            par.right = null;
            q2 = q1;
            if(q2.size()==0)
                break;
            q1 = new LinkedList<Node>();
          }
        
        return root;
    }
}