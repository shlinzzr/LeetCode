// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        
        
        int len = strs[0].length();
        
        for(int j=0; j<len; j++){
            char ch = strs[0].charAt(j);
            boolean same = true;
            for(int i=1; i<strs.length; i++){
                if(ch!=strs[i].charAt(j))
                    return sb.toString();
                    
            }    
            sb.append(ch);
        }
        
        return sb.toString();        
    }
}