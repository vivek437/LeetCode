class Solution {
    public String removeDuplicates(String s, int k) {
      
            s = s + " ";
            int f = 1;
            int l = s.length();
            String lastChar = "",w = s;
            while(f == 1){    
              
                s = w;
                s = s + " ";
                l = s.length(); 
                w = "";
                f = 0;
                int i = 0,count = 0;
                while(i<l){
                    
                    char c = s.charAt(i);      
                    if(lastChar.length()> 0 && lastChar.charAt(0) == c){
                        lastChar = lastChar + c;
                        count++;
                        if(count+1 == k){
                           
                            lastChar = "";
                            count = 0;
                            f=1;
                        }
                    }
                    else{
                        count = 0;
                        w = w + lastChar;
                        lastChar = "";
                        lastChar =  lastChar + c;
                    }
                    i++;
                }    
            }
        return w.trim();
      }
}