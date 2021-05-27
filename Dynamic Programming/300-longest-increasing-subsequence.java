import java.io.*;
class Solution {
    public int lengthOfLIS(int[] a) {
        
       
        int n = a.length;
        int l[]=new int[n];
        l[0]=0;
        for(int i=1;i<n;i++){
             for(int j=0;j<i;j++){
                 if(a[j]<a[i])
                     l[i]=Math.max(l[i],l[j]+1);
           }
        }
         int max=0;
         for(int i=0;i<n;i++){
             if(l[i]>max)
                 max=l[i];
         }
        return (max+1);
    }
}