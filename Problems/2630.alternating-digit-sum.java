// https://leetcode.com/problems/alternating-digit-sum

class Solution {
    public int alternateDigitSum(int n) {
        boolean pos = true;
        int sum=0;
        
        String s = String.valueOf(n);
        
        for(int i=0; i<s.length(); i++){
            
            if(pos)
                sum+=s.charAt(i)-'0';
            else 
                sum-=s.charAt(i)-'0';
            pos = !pos;
        }
        
        return sum;
    }
}