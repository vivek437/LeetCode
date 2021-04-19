/*
https://leetcode.com/problems/combination-sum/
*/

class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
              
        solve(candidates,target,candidates.length,new ArrayList<Integer>());
        return ans;
    }

  
  
    void solve(int[] nums,int target,int i, List<Integer> hm){
         if(target == 0){
             ans.add(new ArrayList<Integer>(hm));
             return;
         }

         if(i<=0)
              return;
         
         if(target-nums[i-1]>=0){
             hm.add(nums[i-1]);
             solve(nums,target-nums[i-1],i,hm);
             hm.remove(hm.size()-1);
             solve(nums,target,i-1,hm);
         }
         else
             solve(nums,target,i-1,hm);
   }
}
