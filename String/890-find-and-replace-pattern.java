class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
          
        HashMap<Character,List<Integer>> hm = new HashMap<>();
        List<Integer> checkList= new ArrayList<Integer>();
        for(int i = 0;i<pattern.length();i++){
                char ch = pattern.charAt(i);
                List<Integer> list = hm.getOrDefault(ch,new ArrayList<Integer>());
                if(list.size() == 0)
                    checkList.add(i);
                list.add(i);
                hm.put(ch,list);
        }
          
        List<String> res = new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {
            String s = words[i];
            int l = checkList.size();
            int f = 0;
            int[] vis = new int[26];
            for(int j = 0; j < l ;j++)
            {
                char  ch = pattern.charAt(checkList.get(j));
                List<Integer> list = hm.get(ch);
                
                char matchChar = s.charAt(list.get(0));
               
                int val = (int)matchChar;
                val = val%97;
                if(vis[val] == 1)
                {
                    f = 1;
                    break;
                }
                vis[val] = 1;
                for(int k = 1 ; k < list.size();k++){
                      if(s.charAt(list.get(k)) == matchChar)
                          continue;
                      else{
                          f = 1;
                          break;
                      }
                }
                if( f == 1)
                    break;
            }
            if( f == 0)
               res.add(s);
        }
        
        return res;
    }
}