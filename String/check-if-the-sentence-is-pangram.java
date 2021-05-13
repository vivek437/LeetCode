class Solution {
    public boolean checkIfPangram(String s) {
        
        int a[] =new int[26];
        
        int l = s.length();
        int c =0;
        for(int i=0;i<l;i++){
            
            char ch = s.charAt(i);
            int p = (int)ch;
            p = p%97;
            if(a[p] == 0){
                a[p] = l;
                c++;
            }
        }
        if(c==26)
            return true;
        else
            return false;
    }
}