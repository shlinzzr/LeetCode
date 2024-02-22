// https://leetcode.com/problems/number-of-even-and-odd-bits

class Solution {
    public int[] evenOddBit(int n) {
        String s = Integer.toBinaryString(n);
        s = new StringBuilder(s).reverse().toString();
        int len = s.length();
        int even=0;
        int odd=0;
        
        for(int i=0; i<len; i++){
            if(s.charAt(i)=='1' && i%2==0)
                even++;
            else if(s.charAt(i)=='1' && i%2==1)
                odd++;
        }
        
        return new int[]{even, odd};
    }
}