// https://leetcode.com/problems/sum-of-square-numbers

class Solution {
    public boolean judgeSquareSum(int c) {
        
        
        
        for(int i=0; i<=Math.sqrt(c); i++){
            
            for(int j=i; j<=Math.sqrt(c); j++){
                
                
                int val = i*i + j*j;
                
                // System.out.println(val);
                if(i*i + j*j==c)
                    return true;
            }
        }
        
        return false;
    }
}