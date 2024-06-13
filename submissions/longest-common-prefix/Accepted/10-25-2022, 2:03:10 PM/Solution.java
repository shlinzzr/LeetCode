// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        
        int min=200;
        
        for(String s : strs){
            min = Math.min(min , s.length());
        }
        
        char c = '1';
        for(int i=0; i<min; i++){
            
            boolean bk =false;
            for(int j=0; j<strs.length; j++){
                String s = strs[j];    
                if(j==0)
                    c=s.charAt(i);
                else{
                    if(c!=s.charAt(i))
                        return sb.toString();
                }
                                
                
            }    
            
            
            sb.append(strs[0].charAt(i));
        }
        
        return sb.toString();
    }
}