class Solution {
    public int countSquares(int[][] a) {
      
       
        int m = a.length;
        int n = a[0].length;
        int dp[][]=new int[m][n];
        int count =0;
        for(int i=0;i<m;i++){
           
            for(int j=0;j<n;j++){
                
                if(a[i][j]>0 && i>0 && j>0){
                    dp[i][j]=Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    count = count  +dp[i][j];
                }
                else if(a[i][j]>0)
                {
                    dp[i][j]=1;
                    count = count+1;
                }
            }
        }
        
        return count;
    }
}