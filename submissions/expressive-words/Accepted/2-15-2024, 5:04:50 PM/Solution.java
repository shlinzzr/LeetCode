// https://leetcode.com/problems/expressive-words

class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int res = 0;
        
        for(int i=0; i<words.length;i++){
            
            String w = words[i];
            
            int sIdx = 0;
            int wIdx = 0;
            
            boolean match = true;
            
            while(match && sIdx<s.length() && wIdx < w.length()){
                 
                int sCnt = getSameLen(s, sIdx);
                char sChar = s.charAt(sIdx);
                sIdx+=sCnt;
                
                char wChar = w.charAt(wIdx);
                int wCnt = getSameLen(w, wIdx);
                wIdx += wCnt;
                
                if( wChar!=sChar || sCnt<wCnt || (sCnt==2 && wCnt==1)){
                    match=false;
                    break;
                }
            }
            
            if(sIdx==s.length() && wIdx==w.length()  && match){
                res++;
            }
             
        }
        return res;
        
        
    }
    
    
    private int getSameLen(String s , int idx){
        
        char ch = s.charAt(idx);
        
        int st = idx;
        while(idx+1<s.length() && s.charAt(idx+1)==ch){
            idx++;
        }
        return idx-st+1;
        
        
    }
}


