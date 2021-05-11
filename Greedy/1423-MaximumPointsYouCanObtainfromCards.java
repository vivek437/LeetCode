/*
https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
*/

class Solution {
    public int maxScore(int[] c, int k) {
      
       int sum = 0, p = -1 , max = 0; 
       for(int i = 0;i<k;i++){
           sum = sum + c[i];
           if(sum > max)
                max = sum;
           p++;
       }
       
       int n = c.length - 1,k1 = k;
       while(k1>0){
           
           sum = sum + c[n];
           sum = sum - c[p];
           if(sum > max)
               max = sum;
           p--;
           n--;
           k1--;
       }
        
        return max;
    }
}
