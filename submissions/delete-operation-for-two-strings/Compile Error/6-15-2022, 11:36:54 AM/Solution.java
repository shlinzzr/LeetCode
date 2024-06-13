// https://leetcode.com/problems/delete-operation-for-two-strings


// // approach 1 recursive lcs (longest common string)
// public class Solution {
//     public int minDistance(String s1, String s2) {
//         return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length());
//     }
//     public int lcs(String s1, String s2, int m, int n) {
//         if (m == 0 || n == 0)
//             return 0;
//         if (s1.charAt(m - 1) == s2.charAt(n - 1))
//             return 1 + lcs(s1, s2, m - 1, n - 1);
//         else
//             return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
//     }
// }

// approach 2 use memo array
public class Solution {
    public int minDistance(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.lengh() + 1];
        return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length(), memo);
    }
    public int lcs(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0)
            return 0;
        if (memo[m][n] > 0)   // keypoint is here, fast return
            return memo[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        else
            memo[m][n] = Math.max(lcs(s1, s2, m, n - 1, memo), lcs(s1, s2, m - 1, n, memo));
        return memo[m][n];
    }
}
