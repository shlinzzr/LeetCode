// https://leetcode.com/problems/maximum-number-of-accepted-invitations

class Solution {
    /*
        Concept : Maximum Bipartite graph
    */
    public int maximumInvitations(int[][] grid) {
        int m = grid.length; // boys
        int n = grid[0].length; // girls

        int[] girlFixed = new int[n];// girl[j] = boy
        Arrays.fill(girlFixed, -1);

        int invitations = 0;

        // boy0 -> girlj
        // try to find a girl for i but also make previous boys that have girls still have girls
        for (int i = 0; i < m; i++) {
            if (isBipartiteMatch(grid, i, new HashSet<>(), girlFixed)) {
                invitations++;
            }
        }
        return invitations;
    }

    private boolean isBipartiteMatch(int[][] grid, int boy, Set<Integer> seenGirl, int[] girlFixed) {
        int m = grid.length; // boys
        int n = grid[0].length; // girls

        for (int j = 0; j < n; j++) {
            if (grid[boy][j] == 1 && !seenGirl.contains(j)) {
                seenGirl.add(j);
                // found a non-match girl || another previous boy can find another non-match girl
                if (girlFixed[j] == -1 || isBipartiteMatch(grid, girlFixed[j], seenGirl, girlFixed)) {
                    girlFixed[j] = boy;
                    return true;
                }
            }
        }
        return false;
    }
}