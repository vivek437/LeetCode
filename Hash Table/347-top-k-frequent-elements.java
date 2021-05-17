import java.util.Map.Entry;
import java.util.PriorityQueue;
class Solution {
    public int[] topKFrequent(int[] a, int k) {
      		  
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        HashMap<Integer,List<Integer>> hm1=new HashMap<Integer,List<Integer>>();
        int l=a.length;
        for(int i=0;i<l;i++){
            int x=a[i];
            if(hm.containsKey(a[i])){
                hm.put(x,hm.get(x)+1);
            }
            else{
                hm.put(x,1);
            }
        }
         PriorityQueue<Integer> pq =  
		             new PriorityQueue<Integer>(); 
         for(Entry<Integer,Integer> mapElement : hm.entrySet()) { 
			 int value=mapElement.getValue();
			 int key=mapElement.getKey();
			 if(hm1.containsKey(value)){
				   List<Integer> xx=hm1.get(value);
				   xx.add(key);
	               hm1.put(value,xx);
	            }
	            else{
	              List<Integer> xx=new ArrayList<Integer>();
	              xx.add(key);
	               hm1.put(value,xx);
	            }
			 
			  if(pq.size()<k) {	        	  
	        	   pq.add(value);
	        	   continue;
	           }
	              if(value>pq.peek()) {	         
	        	   pq.poll();
	               pq.add(value);
	           }
	        
	       } 
         // System.out.println(hm);
         // System.out.println(hm1);
         // System.out.println(pq);
        int res[]=new int[k];
        int i=0;
        int last=0;
        while(i<k) {
            int ab=pq.poll();
            if(last==ab && i!=0)
                continue;
              last=ab;
            List<Integer> x1=hm1.get(ab);
            if(x1.size()>1) {
            	for (int num : x1) {
            		res[i]=num;
            		i++;
            		if(i>=k)
            			break;
        		}
            }
            else { 
            	res[i]=x1.get(0);
            	i++;
            }
        }
        return res;
    }
}