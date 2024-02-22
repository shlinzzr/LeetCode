// https://leetcode.com/problems/remove-trailing-zeros-from-a-string

class Solution {
    public String removeTrailingZeros(String num) {
        
        StringBuilder sb = new StringBuilder(num);
        
        for(int i=num.length()-1; i>=0; i--){
            
            if(num.charAt(i)=='0')
                sb.deleteCharAt(i);
            else 
                break;
        }
        
        return  sb.toString();
    }
}