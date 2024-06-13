// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance

class Solution {
    public int findTheCity(int n, int[][] edges, int d) {
        // Map<Integer, Map<Integer, Integer>> g = new HashMap<>();

        // for(int[] e: edges){
        //     int from = e[0];
        //     int to = e[1];
        //     int weight = e[2];
        //     if(weight>distanceThreshold)
        //         continue;
        //     g.putIfAbsent(from, new HashMap<>());
        //     g.get(from).put(to, weight);

        //     g.putIfAbsent(to, new HashMap<>());
        //     g.get(to).put(from, weight);
        // }

        int[][] cost = new int[n][n];

        for(int[] c : cost){
            Arrays.fill(c, Integer.MAX_VALUE/2);
        }
        
        for(int[] e : edges){
            int from = e[0];
            int to    = e[1];
            int weight = e[2];

            cost[from][to] = weight;
            cost[to][from] = weight;
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){

                    if(i==j) cost[i][j] = 0;
                    else 
                        cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }

        int res= -1;
        int maxCnt = n+1;
        for(int i=0; i<n; i++){
            int cnt =0;
            for(int j=0; j<n; j++){
                // if(i==j) continue;
                if(cost[i][j]<=d){
                    cnt++;
                }
            }

            if(cnt <= maxCnt){
                maxCnt= cnt;
                res = i;
            }
        }
        return res;
    }
    
}