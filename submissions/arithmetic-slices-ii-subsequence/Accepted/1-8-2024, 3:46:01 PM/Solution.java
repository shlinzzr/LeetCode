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
        int[][] dp = new int[n][n]; //以i為結尾的, diff=d時的 subseq數量
        // diff range 到2^31-1 太大了, 改用map array宣告

        //dp 定義改為 以i, j 為最後兩項的時候subseq數量

        Map<Long, List<Integer>> map = new HashMap<>(); // < diff, List<idx> >
        for (int i = 0; i < n; i++) {
            map.putIfAbsent((long) A[i], new ArrayList<>()); //  val, List<valIndex>
            map.get((long) A[i]).add(i);
        }

        //  -1      -1         4       6      
        // "k1" x "k2"  x x x "j" x x "i" x x 
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff =  2 *  (long) A[j] - A[i]; // 2*4-6
                if (map.containsKey(diff)) {
                    for (int k : map.get(diff)) {
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

         