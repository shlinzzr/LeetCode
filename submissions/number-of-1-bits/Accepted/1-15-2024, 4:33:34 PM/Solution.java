// https://leetcode.com/problems/number-of-1-bits

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        
        int cnt=0;
        for(int i=0; i<s.length(); i++){
            
            if(s.charAt(i)=='1')
                cnt++;
        }
        
        return cnt;
    }
}