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
           // System.out.println(hm);
        }
        return wall.size()-max;
    }
}



// [[1,2,2,1],
//  [3,1,2],
//  [1,3,2],
//  [2,4],
//  [3,1,2],
//  [1,3,1,1]]

// [ 1 , -1 , 3  , -1 ,  5 , 6]
// [-1 , -1 , 3  ,  4 , -1 , 6]
// [ 1 , -1 , -1 ,  4 , -1 , 6]
// [-1 ,  2 , -1 , -1 , -1 , 4]
// [-1 , -1 , 3  ,  4 , -1 , 6]
// [ 1 , -1 , -1  , 4  , 5 ,6]