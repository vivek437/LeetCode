/*
https://leetcode.com/problems/course-schedule-iii/
*/

class Solution{
  
  
    public int scheduleCourse(int[][] courses) {
      
      Arrays.sort(courses, (a,b) -> a[1] - b[1]);
      
      PriorityQueue<Integer> pq =  new PriorityQueue < > ((a, b) -> b - a);
      int time = 0;
      for(int[] c : courses){
        
          if(time + c[1] >  c[0])
          {
            time = time + c[1];
            pq.offer(c[0]);
          }
          else if( !pq.empty() && pq.peek()>c[0]){
                time += c[0] - queue.poll();
                queue.offer(c[0]);
          }
       }
        return pq.size();
    }
}
