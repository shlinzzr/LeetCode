// https://leetcode.com/problems/make-costs-of-paths-equal-in-a-binary-tree

class Solution {
    int res = 0;
    public int minIncrements(int n, int[] cost) {
       
        dfs(0, cost);
        return res;
    }
    private int dfs(int i, int[] cost) {
        if (i >= cost.length) return 0;
        int a = dfs(2 * i + 1, cost), b = dfs(2 * i + 2, cost);
        res += Math.abs(a - b);
        return cost[i] + Math.max(a, b);
    }
}

        
        
        // 100
         // 200 300
             
             
             //  300
        
//                             764
//                     1460                 2664
//                 764   2725             4556    5305
//             8829  5064   5929 7660  6321  4830  7055 3761              
        
