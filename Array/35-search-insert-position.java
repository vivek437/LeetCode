class Solution {
    public int searchInsert(int[] nums, int target) {
        
        
        int start = 0, end = nums.length-1;
        
        int mid = 0, f = 0;
        while(start<=end){
            mid = (start + end)/2;
            if(nums[mid] < target)
                 start =  mid + 1;
            else if(nums[mid] > target)
                end = mid - 1;
            else
            {
                f = 1;
                break;
            }
        }
        
        if ( f==1 )
            return mid;
        else if(nums[mid] < target )
            mid++;
        return mid;
    }
}