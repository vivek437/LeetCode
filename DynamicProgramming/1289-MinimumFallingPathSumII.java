/*
https://leetcode.com/problems/minimum-falling-path-sum-ii/
*/
class Solution {
    HashMap<String,Integer> hm;
    int dp[][];
    public int minFallingPathSum(int[][] arr) {
        
         int r = 0,c = 0;
         r = arr.length;
         c = arr[0].length;
         dp = new int[r+1][c+1];
        
         int hs = 0;
         int min = Integer.MAX_VALUE;
         
         for(int i=0;i<r;i++){   
              for(int k=0;k<c;k++){  
                  dp[i][k] = -1;
              }
         }
         hm = new HashMap<String,Integer>();
         for(int k=0;k<c;k++){   
             int x = solve(arr,0,k); 
              if(x<min)
                  min = x;
         }
         return min;
    }
    
   int solve(int[][] arr,int i,int j){
         
        int row = arr.length;
        int col = arr[0].length;
        int val  = arr[i][j];

        if(dp[i][j] != -1)
              return dp[i][j];
       
        if(i< row-1){
                int min = Integer.MAX_VALUE;
                for(int k=0;k<col;k++){                      
                      if(k == j)
                            continue;
                      int y = 0 ;
                     
                      if(dp[i][j] != -1)
                           y = dp[i+1][k];
                      else{
                           y = solve(arr,i+1,k);
                           dp[i+1][k] = y;
                      }
                     
                      if(y<min)
                           min = y;
                 }
              
               val = val+min;
         }
         dp[i][j] = val; 
         return dp[i][j];   
    }
}
