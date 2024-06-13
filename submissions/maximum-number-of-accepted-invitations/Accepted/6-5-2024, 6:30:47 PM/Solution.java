// https://leetcode.com/problems/maximum-number-of-accepted-invitations

class Solution {
    public int maximumInvitations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] girlFixed = new int[n];
        Arrays.fill(girlFixed, -1);

        // buildmap
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    map.putIfAbsent(i, new ArrayList<>());
                    map.get(i).add(j);
                }
            }
        }

        int cnt= 0 ;
        for(int i=0; i<m; i++){ // loop all boy
            Set<Integer> seen = new HashSet<>();
            if(dfs( i, seen, map, girlFixed)){
                cnt++;
            }
        }

        return cnt;
    }

    private boolean dfs(int boy, Set<Integer> seen,  HashMap<Integer, List<Integer>> map, int[] girlFixed ){
        for(int next : map.getOrDefault(boy, new ArrayList<>())){
            if(!seen.contains(next)){
                seen.add(next);
                //女生還沒填的話就填男生, 如果已經填了男生, 就用已填的男生去配別的女生看看
                if(girlFixed[next]==-1 || dfs(girlFixed[next], seen, map, girlFixed)){
                    girlFixed[next] = boy;
                    return true;
                }
            }
        }

        return false;
    }
}