class Solution {
    class Task{
        int enqT;
        int prT;
        int id;
        Task(){
            
        }
    }
    class TaskSort implements Comparator<Task> {  
        public int compare(Task a, Task b)
        {
            if(a.prT != b.prT)
               return a.prT > b.prT ? 1:-1;
            else
              return a.id > b.id ? 1:-1;
        }
    }
    class TaskEnQSort implements Comparator<Task> {  
        public int compare(Task a, Task b)
        {
            if(a.enqT != b.enqT)
               return a.enqT > b.enqT ? 1:-1;
            else 
              return a.prT > b.prT ? 1:-1;
        }
    }
    public int[] getOrder(int[][] tasks) {
        
            int r = tasks.length;
            int pos  = 0;
            List<Task>  allTasks = new ArrayList<Task>();
            while(pos<=r-1 ){
                      Task  t = new Task();
                      t.enqT = tasks[pos][0];
                      t.prT = tasks[pos][1];
                      t.id = pos;
                      allTasks.add(t);
                      pos++;
           }
           Collections.sort(allTasks,
                         new TaskEnQSort());
           
           
         
           PriorityQueue<Task> pQueue = new PriorityQueue<Task>( new TaskSort());
           List<Task>  availableTasks = new ArrayList<Task>();
           int p = 0, time = 0;
           int[] ans = new int[r];
           int m = 0;
           while(p<=r-1 || pQueue.size()>0 ){
                        
                  while(p<=r-1 && allTasks.get(p).enqT <= time){
                      Task  t = new Task();
                      t.enqT = allTasks.get(p).enqT;
                      t.prT = allTasks.get(p).prT;
                      t.id = allTasks.get(p).id;
                      pQueue.add(t);
                      p++;
                 }
               
               if(pQueue.size() == 0){
                      time = allTasks.get(p).enqT;

                      while(p<=r-1 && allTasks.get(p).enqT <= time){
                          Task  t = new Task();
                          t.enqT = allTasks.get(p).enqT;
                          t.prT = allTasks.get(p).prT;
                          t.id = allTasks.get(p).id;
                          pQueue.add(t);
                          time = allTasks.get(p).enqT;
                          p++;            
                      }                     
                }
               
//                Collections.sort(availableTasks,
//                          new TaskSort());
                
//                  for(int i=0;i<availableTasks.size();i++){
//                      System.out.println(availableTasks.get(i).enqT+" "+availableTasks.get(i).prT+" "+availableTasks.get(i).id);
//                  }
//                 System.out.println();
               
                Task x = pQueue.poll();
                // availableTasks.remove(0);
                time += x.prT;
                ans[m] = x.id;
                m++;
          }
        return ans;
    }
}