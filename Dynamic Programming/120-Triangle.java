/*
https://leetcode.com/problems/triangle/
*/

class Solution {
    
    int min = 0;
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = 0;
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        String k = 0+"-"+0;
        ans = solve(triangle, 0, 0, hm);
        
        return ans;
    }
    
    
   int solve(List<List<Integer>> trle, int i, int j,HashMap<String,Integer> hm) {  
          
          int rL = trle.size();
          if(i > rL-1){
              return 0;
          }   
          
          List<Integer> row = trle.get(i);
          if(i == rL-1){
              return row.get(j);
          }
         
          String k = i+"-"+j;
          if(hm.containsKey(k)){
               return hm.get(k);
          }
          
          int cL = row.size();
         
          String k1 = (i+1)+"-"+j;
          int x = 0;
          if(hm.containsKey(k)){
               x = hm.get(k);
          }else{
               x = solve(trle, i+1, j,hm);
          }
       
          if(cL>=j+1){
              String k2 = (i+1)+"-"+(j+1);
              int y = 0;
              if(hm.containsKey(k2)){
                   y = hm.get(k);
              }else{
                   y = solve(trle, i+1, j+1,hm);
              }
              
           if(x<y){
                hm.put(k,row.get(j) + x);
                return row.get(j) + x;
            }
            else{
                hm.put(k,row.get(j) + y);
                return row.get(j) + y;
            }
          }
          else
                hm.put(k,row.get(j) + x); 
          return row.get(j) + x;
    }
}
