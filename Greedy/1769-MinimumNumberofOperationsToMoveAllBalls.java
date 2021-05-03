
/*

https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

*/

class Solution {
    public int[] minOperations(String s) {
           
           int n = s.length(),c = 0, t = 0;
           int[] sum = new int[n];
           int[] count = new int[n];        
           int ans[]=new int[n];

           for(int i = 0 ;i<n;i++){  
                   char ch =  s.charAt(i);
                   if(ch == '1'){
                       c++;
                       t = t + i;                      
                   }
                   count[i] = c;
                   sum[i] = t;    
           }

          int x = 0, y = 0;
          ans[0] = (sum[n-1] - sum[0]);  
          for(int i = 1 ;i<n;i++){         
                 x  = sum[i-1] - (count[i-1]*i);
                 y  = (sum[n-1] - sum[i]) - (count[n-1]-count[i])*i;  
                 if( x < 0)
                     x = x*-1;
                 ans[i] = x+y;
          }   
         return ans;
    }
}
