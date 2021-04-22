/*
https://leetcode.com/problems/brick-wall/
*/

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        int s = 0; 
        for(int i = 0; i<wall.get(0).size(); i++){
             s = s + wall.get(0).get(i);
        }
        
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int max = 0;
        for(int i=0;i<wall.size();i++){
            int x = 0;
            
            for(int j=0;j<wall.get(i).size();j++) {

                int p = wall.get(i).get(j);
                x = x + p - 1;
                int val = hm.getOrDefault(x,0);
                val = val + 1;
                hm.put(x, val);
                if(val > max && x!=s-1 )
                     max = val;
                x++;
           }
        }
        return wall.size()-max;
    }
}
