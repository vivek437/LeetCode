class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
           int o[] = new int[strs.length];
           int z[] = new int[strs.length];
           for(int i=0;i<strs.length;i++){
                 String x = strs[i];
                 for(int j=0;j<x.length();j++){
                     char ch = x.charAt(j);
                     if(ch == '1')
                         o[i] = o[i]+1;
                     else
                         z[i] = z[i]+1;
                 }
           }
        int l = strs.length;
           int dp[][][] = new int[n+1][m+1][l+1];
           for(int i=0;i<=n;i++){
                 for(int j=0;j<=m;j++){
                     for(int k=0;k<=l;k++){
                     dp[i][j][k] = -1;
                    }
               }
           }
           
         solve(strs,m,n,strs.length,o,z,dp);
        return dp[n][m][l];
    }

    public int solve(String[] strs,int m,int n,int l,int[] o,int[] z,int[][][] dp){
        
        if(l<1)
            return 0;
        
        if(dp[n][m][l] != -1)
            return dp[n][m][l];
        
        if(o[l-1]<=n && z[l-1]<=m){
          return dp[n][m][l] = Math.max(1 + solve(strs,m-z[l-1],n-o[l-1],l-1,o,z,dp), solve(strs,m,n,l-1,o,z,dp));
        }
        else{
            return dp[n][m][l] = solve(strs,m,n,l-1,o,z,dp);
        }
    }
}













