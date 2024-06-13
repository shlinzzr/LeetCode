// https://leetcode.com/problems/arithmetic-slices-ii-subsequence


class Solution {
    public int numberOfArithmeticSlices(int[] A) {


        /*
            dp[2][1] = dp[1][0] +1;
            dp[3][2] = dp[2][1] +1
            dp[4][3] = dp[3][2] +1
            dp[4][2] = dp[2][0] +1
            dp[i][j] = dp[j][k] +1

        */
        int n = A.length;
        int[][] dp = new int[n][n];
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent((long) A[i], new ArrayList<>()); //  val, List<valIndex>
            map.get((long) A[i]).add(i);
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long target = 2 * (long) A[j] - A[i];
                if (map.containsKey(target)) {
                    for (int k : map.get(target)) {
                        if (k < j) {  // check valIndex 
                            dp[i][j] += (dp[j][k] + 1); // 
                        }
                    }
                }
                res += dp[i][j];
            }
        }
        
        return res;
    }
}

         