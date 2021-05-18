class Solution {
    public int minDistance(String w1, String w2) {
        
        int m = w1.length();
        int n = w2.length();
        int dp[][] = new int[m+1][n+1];
       
        for(int  i=0;i<m;i++){
            for(int  j=0;j<n;j++){
                  dp[i][j] = -1;
            }
        }
        int x = solve(w1,w2,0,0,dp); 
        return (m+n) - x*2;
    }
    
   int solve(String w1,String w2,int i,int j,int[][] dp) {
        int count = 0;
        if(i>w1.length()-1 || j>w2.length()-1){
            return 0;
        }
        
        if(dp[i][j] != -1)
             return dp[i][j];
       
        if(w1.charAt(i) ==  w2.charAt(j))
        {
            return dp[i][j] =  1 + solve(w1,w2,i+1,j+1,dp);
        }
        return dp[i][j] = Math.max(solve(w1,w2,i+1,j,dp),solve(w1,w2,i,j+1,dp));
        
    }
}

