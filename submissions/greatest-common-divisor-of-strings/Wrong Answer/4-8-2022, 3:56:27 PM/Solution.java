// https://leetcode.com/problems/greatest-common-divisor-of-strings

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length()< str2.length())
            return  "";
        
        String ans = "";
        for(int i=str2.length(); i>0; i--){
            String sub = str2.substring(0, i);
            if(str1.replaceAll(sub, "").length()==0 && str2.replaceAll(sub, "").length()==0)
                ans = sub;
        }
        return ans;
    }
}