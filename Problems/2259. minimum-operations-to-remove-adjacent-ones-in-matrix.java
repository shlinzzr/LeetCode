// https://leetcode.com/problems/minimum-operations-to-remove-adjacent-ones-in-matrix

class Solution {

    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // HashSet<Integer> seen = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    map.putIfAbsent(i*n+j, new ArrayList<>());

                    for(int[] d : dirs){
                        int r = i+d[0];
                        int c = j+d[1];
                        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]!=1) continue;
                        // seen.add(r*n+c);
                        map.get(i*n+j).add(r*n+c);
                    }
                }
            }
        }

        HashMap<Integer, Integer> match = new HashMap<>();

        int cnt = 0;
        for(int i=0; i<m*n; i++){

            if(match.containsKey(i)) continue;
            if(dfs(i, map, match, new HashSet<>())){
                cnt++;
            }
        }
        return cnt;
    }

    private boolean dfs(int cur,  HashMap<Integer,List<Integer>> map, HashMap<Integer, Integer> match , HashSet<Integer> seen){
        for(int next : map.getOrDefault(cur, new ArrayList<>())){
            if(!seen.contains(next)){
                seen.add(next);
                if(!match.containsKey(next) || dfs(match.get(next), map, match, seen)){
                    match.put(next, cur);
                    match.put(cur, next);
                    return true;
                }
            }
        }

        return false;


    }
}