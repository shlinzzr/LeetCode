// https://leetcode.com/problems/nth-digit

class Solution {
    public int findNthDigit(int n) {
    /*
        https://www.youtube.com/watch?v=3aYhWdCXU5I
        find the actual number where the nth digit is from
        find the length of the number where the nth digit is from
        find the nth digit and return
    */
        
        // 1~9 9
        // 10~99 ->90*2
        // 100~999 -> 900*3
        //.    ....   cnt * len
        //ex 490 - 9 - 180 

        int len = 1;
        long cnt = 9;
        int start = 1;
        while(n-len*cnt>0){
            n -= len * cnt;
            len++;
            cnt*=10;
            start*=10;
        }

        // len = 3
        // cnt = 900
        // start = 100

        int num = start + (n-1)/len;
        int mod = (n-1)%len;
        String  s = Integer.toString(num);

        return s.charAt(mod)-'0';
        





    }
}