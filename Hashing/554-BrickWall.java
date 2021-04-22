/*
https://leetcode.com/problems/brick-wall/
*/

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
                
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int max = 0;
        int r = wall.size(),c =0,x = 0,p=0,val =0;
        
        for(int i=0;i<r;i++){
            x = 0;
            c = wall.get(i).size();
            for(int j=0;j<c-1;j++) {

                p = wall.get(i).get(j);
                x = x + p - 1;
                val = hm.getOrDefault(x,0);
                val = val + 1;
                hm.put(x, val);
                if(val > max)
                     max = val;
                x++;
           }
        }
        return r-max;
    }
}

