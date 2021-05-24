class Solution {
    int N;
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        
        N = nums.length;
        ans = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<Integer>();       
            solve(nums,hs,0,new ArrayList<Integer>());
        return ans;
    }
   
    void solve(int[] nums,HashSet<Integer> hs,int pos,List<Integer> ls) {
        
        if( pos == N) {       
             ans.add(new ArrayList<Integer>(ls));
             return;
        }
           
         for(int i=0;i<N;i++){           
                if(!hs.contains(nums[i])) {
                      ls.add(nums[i]);
                      hs.add(nums[i]);
                      solve(nums,hs,pos+1,ls);
                      ls.remove(pos);
                      hs.remove(nums[i]);
                } 
        }
    }
}