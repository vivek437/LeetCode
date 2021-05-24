class Solution {

    int N;
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        N = nums.length;
        ans = new ArrayList<>();
        
        Arrays.sort(nums);
        boolean[] used = new boolean[N];
        List<Integer> ar = new ArrayList<Integer>();
        
        solve(nums,ar,used,0);
        return ans;
    }
   
    void solve(int[] nums, List<Integer> ls,boolean[] used,int start) {
                  
        ans.add(new ArrayList<Integer>(ls));
        for(int i=start;i<N;i++){   
                if( used[i])
                    continue;
                
                used[i] = true;
                ls.add(nums[i]);
                solve(nums,ls,used,i+1);
                ls.remove(ls.size()-1); 
                used[i] = false;   
                while(i+1<nums.length && nums[i] == nums[i+1])
                    ++i;
        }
    }
}