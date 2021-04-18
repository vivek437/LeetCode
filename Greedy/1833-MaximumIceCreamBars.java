
/*

https://leetcode.com/problems/maximum-ice-cream-bars/

*/

class Solution {
   int max = 0;

    public int maxIceCream(int[] costs, int coins) {
       
           Arrays.sort(costs);
           int l = costs.length;
           int c = 0 ;
           for(int i=0;i<l;i++){
               if(coins - costs[i]>=0){
                  coins =  coins - costs[i] ;
                   c++;
               }
               if(coins == 0 )
                   break;
           }
           return c;
    }
}
