
/*
https://leetcode.com/problems/minimum-falling-path-sum/
*/
class Solution {
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
         
        int r = matrix.length;
        int c = matrix[0].length;
        dp = new int[r+1][c+1];
        
        for(int i = 0; i < r ; i++){
               for(int j = 0; j < c ; j++){
                   dp[i][j] = Integer.MAX_VALUE;
               }
        }
        
        int min = Integer.MAX_VALUE;
        int x = 0, y = 0, z = 0;
         for(int i = 0; i < c ; i++){
             dp[0][i] = solve(matrix,0,i,r,c);
             if( dp[0][i]<min)
                 min =  dp[0][i];
         }  
             return min;
    }
    
  
   public int solve(int[][] matrix,int i,int j,int r,int c){
         int x = 0 ,y = 0,  z= 0 , f1 = 0,f2 = 0;
         
         if(i+1<r){
                  if(j-1>=0){
                    f1 = 1;
                    if(dp[i+1][j-1] == Integer.MAX_VALUE)
                       dp[i+1][j-1] = solve(matrix,i+1,j-1,r,c);
                  }
                 
                  if(dp[i+1][j] == Integer.MAX_VALUE)
                      dp[i+1][j] = solve(matrix,i+1,j,r,c);

                  if(j+1<=c-1){
                     f2 = 1;
                     if(dp[i+1][j+1] == Integer.MAX_VALUE)
                         dp[i+1][j+1] = solve(matrix,i+1,j+1,r,c);
                  }
          
                  int p;
                  if(f1+f2 == 2){
                       p = Math.min(dp[i+1][j-1] ,Math.min(dp[i+1][j],dp[i+1][j+1]));
                  }
                  else if(f1 == 1)
                       p = Math.min(dp[i+1][j-1],dp[i+1][j]);
                  else
                       p = Math.min(dp[i+1][j],dp[i+1][j+1]);

                  return matrix[i][j]  + p;   
         }
         else
               return matrix[i][j];
    }
}
