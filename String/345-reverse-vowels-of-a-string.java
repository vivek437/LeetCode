public class Solution {
    public String reverseVowels(String s) {
        
        
        int en = s.length()-1;
        int st = 0;
        char[] ch = s.toCharArray();
        int f1 = 0, f2 = 0;
        while(st<en){
        
            if(f1 != 1){
                if( ch[st] == 'a' || ch[st] == 'e' || ch[st] == 'i'|| ch[st] == 'o' || ch[st] == 'u' ||
                    ch[st] == 'A' || ch[st] == 'E' || ch[st] == 'I'|| ch[st] == 'O' || ch[st] == 'U' ){
                     f1 = 1;
                }
                else
                    st++;
            }
              if(f2 != 1){
                if( ch[en] == 'a' || ch[en] == 'e' || ch[en] == 'i'|| ch[en] == 'o' || ch[en] == 'u' ||
                    ch[en] == 'A' || ch[en] == 'E' || ch[en] == 'I'|| ch[en] == 'O' || ch[en] == 'U'){
                     f2 = 1;
                }
                else
                    en--;
            }
           
             if( f1 == 1 && f2 == 1){
                char t = ch[st];
                ch[st] = ch[en];
                ch[en] = t;
                f1 = 0;
                f2 = 0;
                st++;en--;
            }
        }
        return toString(ch);
    }
    public String toString(char[] a)
    {
        String string = new String(a);
        return string;
    }
}