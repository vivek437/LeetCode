/*
https://leetcode.com/problems/verifying-an-alien-dictionary/
*/
class Solution {
     public int compare(String s1,String s2){  
         int l1 = s1.length();
         int l2 = s2.length();
         int l=0;
         l = l1>l2?l2:l1;
         for(int i=0;i<l;i++){
             char ch1 = s1.charAt(i);
             char ch2 = s2.charAt(i);
             
             int x = hm.get(ch1);
             int y = hm.get(ch2);
             if(x<y)
                 return 1;
             if(x>y)
                 return 0;
         }
         if(l2<l1)
              return 0;
         return 1;
    }  
     HashMap<Character,Integer> hm;
    public boolean isAlienSorted(String[] words, String order) {
          
        hm = new HashMap<Character,Integer>();
      
        for(int i=0;i<26;i++){
            char ch = order.charAt(i);
            hm.put(ch,i);
        }
        for(int i=0;i<words.length-1;i++){
             int y = compare(words[i],words[i+1]);
             if( y == 1)
                   continue;
             else 
                 return false;
        }
        return true; 
        
    }
}
