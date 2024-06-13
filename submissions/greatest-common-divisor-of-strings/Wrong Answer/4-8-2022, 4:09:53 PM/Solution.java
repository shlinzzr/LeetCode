// https://leetcode.com/problems/greatest-common-divisor-of-strings

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        String ans = "";
        String compare = str1.length() < str2.length() ? str1 : str2;
        int len = compare.length();
        for(int i=1; i<compare.length(); i++){
            
            if(i!=0 && compare.length()%i!=0)
                continue;
            
            String sub = compare.substring(0, len/i);

            
            if(str1.replaceAll(sub, "").length()==0 && str2.replaceAll(sub, "").length()==0)
                return sub;
        }
        return ans;
    }
}