// https://leetcode.com/problems/plus-one

class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        
        boolean flag = true;
        for(int i=n-1; i>=0; i++){
            if(flag == true){
                
                if(digits[i]==9 ){
                    digits[i]=0;
                    flag = true;
                }else{
                     digits[i]++;
                }
               
            }
            
            break;
                
        
        
        }
        
        return digits;
        
        
        
    }
}