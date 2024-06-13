// https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value

class Solution {
    public boolean digitCount(String num) {
        
        int[] arr = new int[10];
        
        int len = num.length();
        for(int i=0; i<len; i++){
            char ch = num.charAt(i);
            arr[ch-'0']++;
        }
        
        for(int i=0; i<len; i++){
            if(arr[i]!= (num.charAt(i)-'0'))
                return false;
        }
        
        return true;
    }
}