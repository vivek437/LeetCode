
class Solution {
    int a[][] ;
    public int longestIncreasingPath(int[][] matrix) {
           
        
          int r = matrix.length;
          int c = matrix[0].length;
          a = new int[r][c];
        
         
          for(int  i=0;i<r;i++) {
              for(int j=0;j<c;j++) {
                   if(a[i][j] != 0)
                        continue;
                   solve(matrix,i,j,r,c,1);
              }
          }
        

          int max = 0;
          for(int  i=0;i<r;i++) {
              for(int j=0;j<c;j++) {
                  // System.out.print(a[i][j]+" ");
                  if(a[i][j]>max)
                      max = a[i][j];
              }
               // System.out.println();
          }
        return max;
    }
    
    public void solve(int[][] mt,int i,int j,int m,int n,int x){
        
           if( x > a[i][j]){
               a[i][j] = x;
           }
           else 
               return;
           
            if(i-1>=0 && j<n && mt[i-1][j]>mt[i][j])
                solve(mt,i-1,j,m,n,x+1);
            if(i<m && j-1>=0 && mt[i][j-1]>mt[i][j])
                solve(mt,i,j-1,m,n,x+1);
            if(i+1<m && j<n && mt[i+1][j]>mt[i][j])
                solve(mt,i+1,j,m,n,x+1);
            if(i<m && j+1<n && mt[i][j+1]>mt[i][j])
                solve(mt,i,j+1,m,n,x+1);
        
    }
}
