// https://leetcode.com/problems/climbing-stairs

// class Solution {
//     public int climbStairs(int n) {
        
//         if(n<=3)
//             return n;
        
//         int a
        
        
//         return climbStairs(n-1) + climbStairs(n-2); 
//     }
// }


// public class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n + 1];
//         if (n == 1) {
//             return 1;
//         }
//         if (n == 2) {
//             return 2;
//         }
//         dp[0] = 0;
//         dp[1] = 1;
//         dp[2] = 2;
//         for (int i = 3; i <= n; i++) {
//           dp[i] = dp[i-1] + dp[i - 2];
//         }
//         return dp[n];
//     }
// }


public class Solution {
    public int climbStairs(int n) {
        
        if(n<=3)
            return n;
        
        int a=0, b=1, c=2, res=0;
        for(int i=3; i<=n; i++){
            res = b + c;
            b = c;
            c = res;
        }
        return res;
    }
}

