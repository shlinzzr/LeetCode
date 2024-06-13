// https://leetcode.com/problems/minimum-operations-to-remove-adjacent-ones-in-matrix

class Solution {

    // ref : 1820

    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        //1. 先建關係圖 buildMap
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


        //準備匈牙利色色法 這邊用map或是int[h*w]都可以
        HashMap<Integer, Integer> match = new HashMap<>();// girlFixed
        int cnt = 0;
        
        for(int i=0; i<m*n; i++){ //男生從0~h*w都要試
            if(match.containsKey(i)) continue; //之前配好的我不管, 如果不continue會重複算到

            HashSet<Integer> seen = new HashSet<>();
            if(dfs(i, map, match, seen)){
                cnt++;
            }
        }
        return cnt;
    }

    private boolean dfs(int cur, HashMap<Integer,List<Integer>> map, HashMap<Integer, Integer> match , HashSet<Integer> seen){
        for(int next : map.getOrDefault(cur, new ArrayList<>())){
            if(!seen.contains(next)){
                seen.add(next);
                if(!match.containsKey(next) || dfs(match.get(next), map, match, seen)){
                    match.put(next, cur); // A->B
                    match.put(cur, next); // B->A 兩種狀況一樣 只做一次 不重複做了
                    return true;
                }
            }
        }

        return false;


    }
}