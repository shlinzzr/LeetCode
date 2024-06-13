// https://leetcode.com/problems/greatest-common-divisor-of-strings

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        // String ans = "";
        String compare = str1.length() < str2.length() ? str1 : str2;
        int len = compare.length();
        for(int i=1; i<=len; i++){
            
            if(len%i!=0)
                continue;
            
            String sub = compare.substring(0, len/i);

            
            if(str1.replaceAll(sub, "").equals("") && str2.replaceAll(sub, "").equals(""))
                return sub;
        }
        return "";
    }
}