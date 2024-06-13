// https://leetcode.com/problems/number-of-1-bits

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        System.out.println(n);
        
        int cnt=0;
        String s =  Integer.toBinaryString(n);
        for(char c : s.toCharArray()){
            if(c=='1')
                cnt++;
        }
        
        return cnt;
    }
}