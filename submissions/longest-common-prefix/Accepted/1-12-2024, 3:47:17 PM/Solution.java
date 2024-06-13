// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int len = Integer.MAX_VALUE; 
        
        for(String s : strs){
            len = Math.min(len, s.length());
        }
        
        for(int i=0; i<len; i++){
            boolean flag = true;
            
            char pre = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++){
                if(strs[j].charAt(i)!=pre) 
                    return sb.toString();
            }
            sb.append(pre);
        }
        return sb.toString();
    }
}