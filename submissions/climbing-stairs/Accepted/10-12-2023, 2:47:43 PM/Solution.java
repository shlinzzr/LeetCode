// https://leetcode.com/problems/climbing-stairs

class Solution {
    public int climbStairs(int n) {
        // 1 => 1
        // 2 => 2
        // 3 => 1+2 || 2+1 || 1+1+1 => 3

        if(n<=3)
            return n;

        int a = 1;
        int b = 1;

        // n==4
        // 1 + 1 = 2 ... 3
        // a + b = c
        //     a + b = 3 ... 2 
        //         2 + 3 = 5 ... 1
        //             3 + 5 = 8
        while(n-->1){
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}