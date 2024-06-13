// https://leetcode.com/problems/plus-one

class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        int carry = 0;
        int plus =1;
        
        for(int i=len-1; i>=0; i--){
            
            int v = digits[i]+ carry + plus;
            plus = 0;
            carry = v/10;
            digits[i] = v%10;
            
        }
        
        if(carry==0) return digits;
        
        int[] res = new int[len+1];
        res[0] = 1;
        System.arraycopy(digits, 0, res, 1, len);
        
        return res;
        
        
    }
}