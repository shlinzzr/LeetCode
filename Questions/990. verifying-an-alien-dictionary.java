// https://leetcode.com/problems/verifying-an-alien-dictionary

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int len = words.length;
        
        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                
                int wli = words[i].length();
                int wlj = words[j].length();
                
                
                if(wli>wlj && words[i].indexOf(words[j])!=-1)
                    return false;
                
                int wl = Math.min(wli, wlj);
                
                for(int w=0; w<wl; w++){
                    
                    char ci = words[i].charAt(w);
                    char cj = words[j].charAt(w);
                    
                    if(order.indexOf(ci)<order.indexOf(cj)){
                        break;
                    }
                    
                    
                    if(order.indexOf(ci)>order.indexOf(cj))
                        return false;
                }
            }
        }
        
        return true;
    
    }
}