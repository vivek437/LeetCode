class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int[] vis = new int[n];
      
        int c = 0,visCount = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        c++;
        visCount++;
        vis[0] = 1;
        
        while(visCount < n){
            
            while(!q.isEmpty()){
                int temp = q.poll();  
                visCount++;
                for(int i=0;i<n;i++){

                       if( isConnected[temp][i] == 1 && vis[i] !=1 ){
                             q.add(i);
                             vis[i] = 1;
                       }
                }
            }
            
            for(int i=0;i<n;i++){
                 if(vis[i]!=1){
                    q.add(i);
                    c++;
                    vis[i] = 1;
                    break;
                 }
            }
        }
        return c;
    }
}