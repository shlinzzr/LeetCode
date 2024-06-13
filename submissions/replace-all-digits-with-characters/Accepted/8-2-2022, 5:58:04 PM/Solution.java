// https://leetcode.com/problems/replace-all-digits-with-characters

class Solution {
    public String replaceDigits(String s) {
        int len = s.length();

        char[] arr=s.toCharArray();
        
        for(int i=0; i<len/2; i++){
            char c = s.charAt(2*i);
            char num = s.charAt(2*i+1);
            
            char t = (char) (c + (num-'0'));
            arr[2*i+1] = t;
        }
        
        return String.valueOf(arr);
        
    }
}