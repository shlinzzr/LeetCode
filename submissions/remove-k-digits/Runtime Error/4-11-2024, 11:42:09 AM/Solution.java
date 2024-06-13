// https://leetcode.com/problems/remove-k-digits

class Solution {

    int min = Integer.MAX_VALUE;
    public String removeKdigits(String num, int k) {

        if(k==0) return num;
        int len = num.length();
        if("0".equals(num)) return num;
        if(len==k) return "0";

        helper(num, k);
        return String.valueOf(min);
    }

    private void helper(String s, int k){

        // System.out.println(s);
        if(k==0){
            int val = s.isEmpty() ? 0 : Integer.valueOf(s);
            if(val<min) min = val;
            return;
        }


        for(int i=0; i<s.length(); i++){
            String left = i==0 ? "" : s.substring(0, i);
            String right = i==s.length()-1 ? "" : s.substring(i+1, s.length());
            helper( left+right, k-1);
        }
    }
}