// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        
        int idx=0;
        
        int min =1000;
        for(String s : strs){
            min = Math.min(s.length(), min);
        }
        
            
        for(int i=0; i<min; i++){
            char cur = strs[0].charAt(i);
            boolean same=true;
            for(int j=1; j<strs.length; j++){
                if(cur!=strs[j].charAt(i))
                    same=false;
            }
            
            if(!same)
                 return prefix.substring(0,idx+1);
            
            idx=i;
        }    
        
        return prefix.substring(0,idx+1);
    }
}