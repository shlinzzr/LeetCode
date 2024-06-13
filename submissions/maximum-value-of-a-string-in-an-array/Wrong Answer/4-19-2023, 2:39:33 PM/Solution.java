// https://leetcode.com/problems/maximum-value-of-a-string-in-an-array

class Solution {
    public int maximumValue(String[] strs) {
        
        int max = 0;
        
        for(String s : strs){
            boolean allDigit=true;
            
            for(char ch : s.toCharArray()){
                if(ch<'0' || ch>'9'){
                    allDigit=false;
                    break;
                }
                    
                int val= allDigit ? Integer.valueOf(s) : s.length();
                max = Math.max(max, val);
                
            }
            
        }
        return max;
        
    }
}