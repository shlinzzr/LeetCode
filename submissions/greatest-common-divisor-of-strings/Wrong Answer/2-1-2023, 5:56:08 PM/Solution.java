// https://leetcode.com/problems/greatest-common-divisor-of-strings

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
         // String compare = str1.length() < str2.length() ? str1 : str2;
        
        String shortt = str1.length()<str2.length()? str1 : str2;
        int len = shortt.length();
        
        for(int i=1; i<=len; i++){
            
            String sub = shortt.substring(0, len/i);
            
            if(str1.replaceAll(sub, "").length()==0 || str2.replaceAll(sub, "").length()==0 )
                return sub;
            
        }
        
        return "";
        
        
    }
}