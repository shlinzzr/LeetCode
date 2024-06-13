// https://leetcode.com/problems/perfect-squares

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        
        dp[0]=0;
        
        for(int i=1; i<=n; i++){
            dp[i] = i;  // 1=1, 2=1+1, 3=1+1+1 so dp[i]=i is base case for 1 square
            for(int j=1; j*j<=i; j++){
                int s = j*j;
                    dp[i] = Math.min(dp[i], dp[i-s]+1);
            }
        }
        
        return dp[n];
    }
    
//     public int numSquares(int n) {
// 	int[] dp = new int[n + 1];
// 	dp[0] = 0;
	
// 	for (int i = 1; i <= n; i++) {
// 		dp[i] = i;
		
// 		for (int j = 1; j * j <= i; j++) {
// 			int square = j * j;
// 			dp[i] = Math.min(dp[i], 1 + dp[i - square]);
// 		}
// 	}
	
// 	return dp[n];
// }

}