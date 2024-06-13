// https://leetcode.com/problems/max-points-on-a-line

class Solution {
    public int maxPoints(int[][] points) {
        return 1%0;
    }
    
    public int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
}