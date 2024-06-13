// https://leetcode.com/problems/find-and-replace-pattern

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> res = new ArrayList<>();
        
        for(String w : words){
            
            
            if(w.length()!=pattern.length())
                continue;
            
            boolean isPattern=true;
            char[] arrPtoW = new char[26];
            char[] arrWtoP = new char[26];
            
            
            for(int i=0; i<w.length(); i++){
                
                char chw = w.charAt(i);
                char chp = pattern.charAt(i);

                
                if(arrPtoW[chp-'a']<'a' || arrPtoW[chp-'a']>'z'){
                    arrPtoW[chp-'a'] = chw;
                    
                }else if(arrPtoW[chp-'a'] != chw){
                    isPattern=false;
                    break;
                }
                
                if(arrWtoP[chw-'a']<'a' || arrWtoP[chw-'a']>'z'){
                    arrWtoP[chw-'a'] = chp;
                    
                }else if(arrWtoP[chw-'a'] != chp){
                    isPattern=false;
                    break;
                }
                
                
                
            }
            
            
            
            
            
            if(isPattern)
                res.add(w);
        }
            
            
            
        return res;    
        
            
    }
}