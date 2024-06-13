// https://leetcode.com/problems/plus-one

class Solution {
    public int[] plusOne(int[] digits) {
     
        int carry=0;
        
        
        for(int i=digits.length-1; i>=0; i--){
            int d = digits[i] + carry;
            
            if(i==digits.length-1)
                d++;
            
            carry = d/10;
            digits[i]=d%10;
        }
        
        int len = digits.length;
        if(carry==1){
            int[] res = new int[len+1];
            res[0]=1;
            for(int i=0; i<digits.length; i++){
                res[i+1] = digits[i];
            }
            return res;
        }
        else{
            
            return digits;
            
        }
        
            
        
        
        
            
        
        
            
        
    }
}