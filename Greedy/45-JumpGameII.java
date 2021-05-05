class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        if(n == 1)
             return 0;
        if(nums[0] >= n-1)
             return 1;
        int x[]=new int[n];
        x[n-1] = 1;

        for(int i=n-2;i>=0;i--){
            int min = Integer.MAX_VALUE - 1;
            int end = i + nums[i];
           
            if(end >= n-1 ){
                x[i] = 1;
                continue;
            }
            if(nums[i] == 0)
            {
                 x[i] = -1;
                 continue;
            }
            
            for(int j=i+1;j<=end;j++){
                if(x[j] > -1 && x[j]<min)
                    min = x[j];
            }
            if(min == Integer.MAX_VALUE){
                 x[i] = -1;
            }
            
            x[i] = min + 1;
        }
        return x[0];
    }
}


// Better Approach
/*
class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
         
        int cf = 0, ce = 0 , j = 0;
        for(int  i=0; i<n-1; i++){
       
            cf = Math.max(cf, i + nums[i]);
            if(i  == ce) 
            {
                j++;
                ce = cf;
            }
            
        }
        
        return j;
    }    
}
*/
