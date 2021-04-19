/*
https://leetcode.com/problems/combination-sum-ii/
*/

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<List<Integer>>();       
        solve(candidates,target,0,new ArrayList<Integer>());
        return ans;
    }
    
    void solve(int[] nums, int target,int start,List<Integer> hm){
           
             if(target == 0){
                   ans.add(new ArrayList<Integer>(hm));
                   return;
             }

            
             for(int j = start ;j<nums.length;j++){
                 if(j>start && nums[j] == nums[j-1]) 
                     continue;
                 if(target <  nums[j])
                     return;
                 else{
                     hm.add(nums[j]);
                     solve(nums,target - nums[j],j+1,hm);
                     hm.remove(hm.size()-1);
                 }
             }
        
    }
}
