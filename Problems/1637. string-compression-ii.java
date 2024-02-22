// https://leetcode.com/problems/string-compression-ii

class Solution {
   
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];  // sol with seeing n char of s and removed k char

        for (int i = n; i >= 0; i--) {
            for (int j = 0; j <= k; j++) {
                // Base case - initial length declaration
                if (i == n) {
                    // dp[n][j] = 0;
                    continue;
                }

                // Case 1 - delete the ith character if possible (j > 0)
                dp[i][j] = (j > 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE;

                /*
                 0      <- i
                "aaabcccdddd"

                .... count = 4
                del(c),
                del(c),
                del(c),

                j=0-> k
                    possible_del = j....0

                dp[i][j] = Math.min(dp[i][j], getLength(count) + dp[end + 1][possible_del]);

                find dp[0][k]

                */


                // Case 2 - we keep the ith index.
                // We have to find the current char's index endpoint
                int possible_del = j, count = 0;
                for (int end = i; end < n && possible_del >= 0; end++) {
                    // Check about the same char "b b b .." for encoding
                    if (s.charAt(end) == s.charAt(i)) {
                        count++;

                        // Assuming the block ends here "aaaa"
                        dp[i][j] = Math.min(dp[i][j], getLength(count) + dp[end + 1][possible_del]);
                    } else {
                        // This character should be deleted to make the length min.
                        possible_del--;
                    }
                }
            }
        }

        return dp[0][k];
    }

     public int getLength(int count) {
        if (count == 1) return 1;
        else if (count < 10) return 2;
        else if (count < 100) return 3;
        else return 4;
    }

}