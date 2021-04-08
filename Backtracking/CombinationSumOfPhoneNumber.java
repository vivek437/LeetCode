/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

*/

class Solution {
    
    List<String> allAns = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        
           if(digits.length() == 0)
           {
               return allAns;
           }
           HashMap<Integer,char[]> hm = new HashMap<Integer,char[]>();
           hm.put(2,new char[]{'a','b','c'});
           hm.put(3,new char[]{'d','e','f'});
           hm.put(4,new char[]{'g','h','i'});
           hm.put(5,new char[]{'j','k','l'});
           hm.put(6,new char[]{'m','n','o'});
           hm.put(7,new char[]{'p','q','r','s'});
           hm.put(8,new char[]{'t','u','v'});
           hm.put(9,new char[]{'w','x','y','z'});
           
           StringBuilder input1 = new StringBuilder();
            input1.append(digits);
            input1.reverse();
           Form(hm,digits.length()-1,input1.toString(),"");
      
           return allAns;
             
    }
          void Form(HashMap<Integer,char[]> hm,int l,String digits,String ans){
              
              if(l<0){
                  allAns.add(ans);
                  return;
              }
              int num = digits.charAt(l) - '0';
              char[] x = hm.get(num);
              for(int i=0;i<x.length;i++){

                    Form(hm,l-1,digits,ans + x[i]);
              }
          }
}
