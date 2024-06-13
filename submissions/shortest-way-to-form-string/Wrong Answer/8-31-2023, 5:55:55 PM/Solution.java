// https://leetcode.com/problems/shortest-way-to-form-string

class Solution {
    public int shortestWay(String target, String source) {
     
        int idx_s=0, idx_t=0;
        
        int len_s = source.length();
        int len_t = target.length();
        
        
        while(idx_s<len_s){
            
            if(idx_t==len_t)
                return len_s-len_t;
            
            
            char chs = source.charAt(idx_s);
            char cht = target.charAt(idx_t);
            
            if(chs==cht){
                idx_t++;
            }
            idx_s++;
            
            System.out.println(idx_t + " " + idx_s);
            
        }
        
        return -1;
        
    }
}