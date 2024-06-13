// https://leetcode.com/problems/minimum-cost-to-buy-apples

class Solution {
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {

        Map<Integer, Map<Integer, Integer>> adjs = new HashMap<>();
        buildMap(roads, adjs);
        long[] res= new long[n];

        LinkedHashMap<String, Long >memo = new LinkedHashMap<>();

        for(int start=1; start<=n; start++){
            boolean[] seen = new boolean[n+1];
            seen[start]=true;
            long rt = dfs(start, 0L, adjs, appleCost, k, seen, memo);
            res[start-1] = rt;
        }

        return res;
        
    }

    private long dfs(int curr, long acc,  Map<Integer, Map<Integer, Integer>> adjs 
    , int[] appleCost, int k, boolean[] seen, LinkedHashMap<String, Long> memo ){

        if(memo.containsKey(memo.keySet().toString()))
            return memo.get(curr);
        
        int takeApple = appleCost[curr-1];

        // return @ curr 
        long res = acc + takeApple + k*acc;


        Map<Integer, Integer> nebs = adjs.getOrDefault(curr, new HashMap<>());
        for(int neb : nebs.keySet()){
            if(seen[neb]) continue;
            seen[neb] = true;
            long roadCost = (long)nebs.get(neb);

            long rt = dfs(neb, acc+roadCost, adjs, appleCost, k, seen, memo);

            // System.out.println(curr+ "->" + neb + "=" + rt);

            res = Math.min(res, rt);
            seen[neb] = false;
        }

        memo.put(curr+"", res);
        return res;



    }

    private void buildMap(int[][] roads, Map<Integer, Map<Integer, Integer>> adjs ){

        int len = roads.length;
        for(int[] r : roads){
            int a = r[0];
            int b = r[1] ;
            int cost = r[2];

            adjs.putIfAbsent(a, new HashMap<>());
            adjs.get(a).put(b, cost);
            adjs.putIfAbsent(b, new HashMap<>());
            adjs.get(b).put(a, cost);
        }

    }
}