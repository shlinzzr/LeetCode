// https://leetcode.com/problems/largest-odd-number-in-string

class Solution {
    public String largestOddNumber(String num) {
        int len = num.length();

        String res = "";
        int ed = len-1;
        for(; ed>=0; ed--){
            char ch = num.charAt(ed);
            if((int) (ch-'0') % 2==1)
                break;
        }   

        return num.substring(0, ed+1);


    }
}