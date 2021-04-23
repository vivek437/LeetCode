/*
https://leetcode.com/problems/count-binary-substrings
*/

class Solution {
    public int countBinarySubstrings(String s) {
        
        int b = 0, z = 0, o = 0, count = 0, f = 0;    
        if(s.charAt(s.length()-1) == '0')
             s = s + '1';
        else
             s = s + '0';
         
        int l = s.length();

        b = 1;
        f = 1;
        if(s.charAt(0) == '0')
             z = 1;
        if(s.charAt(0) == '1')
             o = 1;
        
        while(b<l){
            
             char ch = s.charAt(b);
             char ch1 =  s.charAt(b-1);
             if(ch == ch1)
             {
                    if(ch == '0')
                       z++;
                    else{
                       o++;
                    }
              } 
              else{
                   f++;
                   if(f>2){
                        f = 2;
                        count  = count + (o>z?z:o); 
                        if(ch1 == '1')
                            z = 1;
                        else
                            o = 1; 
                   }
                  else{
                      if(ch == '0')
                        z++;
                      else
                        o++;
                  }
               }
            b++;
          }
         return count;  
    }
}
