// https://leetcode.com/problems/reverse-bits

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String str = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(str);
        sb=sb.reverse();
        while(sb.length()<32){
            sb.append("0");
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}