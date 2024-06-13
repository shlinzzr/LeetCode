// https://leetcode.com/problems/number-of-1-bits

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String bin =  Integer.toBinaryString(n);
        
        int res =0;
        for(char ch : bin.toCharArray()){
            if(ch=='1')
                res++;
        }
        
        return res;
    }
}