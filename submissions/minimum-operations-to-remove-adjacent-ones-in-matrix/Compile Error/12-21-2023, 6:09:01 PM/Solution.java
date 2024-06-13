// https://leetcode.com/problems/minimum-operations-to-remove-adjacent-ones-in-matrix

class Solution {

    int m;
    int n;

    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 想法 : 這是一個bipartite graph : lc1820 => Hungurian algo
        // buildMap

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                if(grid[i][j]==0) continue;
                for(int[] d : dirs){
                    int r = i+d[0];
                    int c = j+d[1];
                    if(r<0 || c<0 || r>=h || c>=w || grid[r][c]!=1) continue;
                    map.putIfAbsent(i*n+j, new ArrayList<>());
                    map.get(i*n+j).add(r*n+c);
                }

            }
        }


        int ans = 0, count = 0;
        int[] match = new int[m*n];
        Arrays.fill(match, -1);

        HashSet<Integer> seen = new HashSet<>();


        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j]>0 && dfs(i, j, ++count, grid, match, seen)){
                    ans++;
                }
            }
        }

        return ans/2; // divide by 2 because we want num of pairs.
    }

    private boolean dfs(int i, int j, int visited, int[][] grid, int[][] match, HashSet<Integer> seen ){
        if (seen[i][j] == visited)
            return false;


        seen[i][j]=visited;
        
        for (int[] d : dirs){
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x == m || y == n || grid[x][y] == 0 || seen[x][y] == visited){
                continue;
            }
            if (match[x][y]==-1 || dfs(match[x][y]/n, match[x][y]%n, visited, grid, match, seen)){
                match[x][y]=i*n+j;
                return true;
            }
        }
        return false;
    }
}