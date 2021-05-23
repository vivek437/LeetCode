class Solution {
    int N;
    List<List<String>> ans;
    public int totalNQueens(int n) {
        
        N = n;
        ans = new ArrayList<>(); 
        HashSet<Integer> filledRows = new HashSet<>();
        int[][] pos = new int[n][n];
        
        placeQueens(filledRows,0,pos,0);
        return ans.size();
    }
    
    
   void placeQueens(HashSet<Integer> filledRows, int nextCol,int[][] pos,int count){
       
        if(count == N) {
            List<String> temp = new ArrayList<>();
            for(int i = 0 ;i< N ; i++){
                  StringBuilder s= new StringBuilder();
                  for(int j = 0 ;j< N ; j++){
                      
                      if(pos[i][j] == 1){
                         s.append("Q");
                         continue;
                      }
                      s.append(".");
                   
                  }
                 temp.add(s.toString());
            }
            ans.add(temp);
            return;
          
        }
        
        for(int row = 0 ;row < N ;row++){
            if(filledRows.contains(row))
                  continue;
            boolean ll = diaContains(row,nextCol,pos);
            if(!ll){
                count++;
                filledRows.add(row);
                pos[row][nextCol] = 1;
                placeQueens(filledRows,nextCol+1,pos,count);
                count--;
                pos[row][nextCol] = 0;
                filledRows.remove(row);  
            }
        }
    }
    
    boolean diaContains(int r,int c,int[][] pos){
      
        int stRow = r-c,stCol = c-r;
        if(stRow<0)
            stRow = 0;
        if(stCol<0)
            stCol = 0;
        
         while(stRow>=0 && stRow<N && stCol<N) {
             if(pos[stRow][stCol] == 1)
                 return true;
             stRow++;
             stCol++;
         }
        
         stRow = r - (N-1-c);stCol = c + r ;
         if(stRow<0)
            stRow = 0;
         if(stCol>=N)
            stCol = N-1;

         while(stRow<=N-1 && stCol>=0  && stCol<=N-1) {
            
             if(pos[stRow][stCol] == 1)
                 return true;
             stRow++;
             stCol--;
         }
       
        return false;
    }
}

