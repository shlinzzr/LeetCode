// https://leetcode.com/problems/find-the-winner-of-the-circular-game

class Solution {
    public int findTheWinner(int n, int k) {
        return solve(n,k) + 1;
    }
    protected int solve(int n, int k){
        if(n == 1) return 0;
        return (solve(n-1,k) + k) % n;
    }
}