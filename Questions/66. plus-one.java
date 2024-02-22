// https://leetcode.com/problems/plus-one

class Solution {
    public int[] plusOne(int[] digits) {
        
        int len = digits.length;
        int idx = len-1;
        
        int carry = 1;
        while(idx>=0 && carry==1){
            int d = digits[idx]+carry;
            
            
            digits[idx] = d%10;
            
            carry = d/10;
            idx--;
        }
        
        
        if(carry==1){
            int[] res = new int[len+1];
            System.arraycopy(digits, 0, res, 1, len);
            res[0] = 1;
            
            digits = res;
        }
        
        return digits;
        
        
        
        
    }
}