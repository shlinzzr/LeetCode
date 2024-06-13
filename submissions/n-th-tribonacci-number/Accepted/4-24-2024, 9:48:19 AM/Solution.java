// https://leetcode.com/problems/n-th-tribonacci-number

class Solution {
    public int tribonacci(int n) {
        int t0 =0;
        int t1 =1;
        int t2 =1;

        if(n<2) return n;
        for(int i=3; i<=n; i++){
            int ti = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = ti;
        }

        return t2;

    }
}