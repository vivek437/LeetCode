class Solution {
    int lastDay = 0 ;
    public int mincostTickets(int[] days, int[] costs) {
        
        int l = days.length;
        lastDay =  days[l-1];
        int[][] dp = new int[days.length+1][lastDay+1];

         dp[0][0] = solve(days,costs,0,0,dp); 
         return dp[0][0];
    }
    
    
   int solve(int[] days,int[] costs,int i,int freeTill,int[][] dp){
        
           if(i>=days.length || freeTill >= lastDay)
               return 0;
           
           if(dp[i][freeTill] != 0)
              return dp[i][freeTill];
           
           if(days[i]<=freeTill){
               dp[i][freeTill] = solve(days,costs,i+1,freeTill,dp);
               return dp[i][freeTill];
           }
          
           else{
                if(days[i]>freeTill)
                    freeTill = days[i]-1;          
                
                
                int x = costs[0] + solve(days,costs,i+1,freeTill + 1 , dp);
                int y = costs[1] + solve(days,costs,i+1,freeTill + 7, dp);
                int z = costs[2] + solve(days,costs,i+1,freeTill + 30, dp);
                
                dp[i][freeTill] = Math.min(x,Math.min(y,z));
                return  dp[i][freeTill];
           }       
    }
}