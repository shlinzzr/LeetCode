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
        
        int minLeft=0;
        int minLen=m+1;
        int wordLen =0;
        
        int st=0;
        for(int ed=0; ed<m; ed++){
            
            char ch = s.charAt(ed);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)>=0)
                    wordLen++;
                
                while(wordLen==n){
                    
                    //update ans
                    if(ed-st+1 < minLen){
                        minLeft = st;
                        minLen= ed-st+1;
                    }
                    
                    // delete head
                    char cc = s.charAt(st);
                    if(map.containsKey(cc)){
                        map.put(cc, map.get(cc)+1);
                        
                        if(map.get(cc)>0)
                            wordLen--;
                    }
                    st++;
                }
            }
        }
        
        if(minLen>m)  
        {  
            return "";  
        }  
        
        
        return s.substring(minLeft, minLeft+minLen);
        
    }
}