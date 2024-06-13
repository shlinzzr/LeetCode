// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        
        
        String res ="";
        int st=0;
        
        
        int minLeft=0;
        int minLen=m+1;
        
        
        int wordLen =0;
        
        for(int ed=0; ed<m; ed++){
            
            char c = s.charAt(ed);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c)>=0)
                    wordLen++;
                
                while(wordLen==n){

                    if(ed-st+1 < minLen){
                        // res = s.substring(st, ed+1);
                        minLeft = st;
                        minLen= ed-st+1;
                    }
                    
                    char ch = s.charAt(st);
                    if(map.containsKey(ch)){
                        map.put(ch, map.get(ch)+1);
                        
                        if(map.get(ch)>0)
                            wordLen--;
                    }
                    st++;
                }
            }
        }
        
        
        
        return s.substring(minLeft, minLeft+minLen);
        
    }
}