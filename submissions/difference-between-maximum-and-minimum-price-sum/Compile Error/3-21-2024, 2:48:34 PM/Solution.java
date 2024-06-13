// https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum

class Solution {
    Map<Integer, Set<Integer>> g;
    // Map<Integer, Integer> sum1 = new HashMap<>();
    // Map<Integer, Integer> sum2 = new HashMap<>();
    long[] sum1;
    long[] sum2;
    long res = 0;
    public long maxOutput(int n, int[][] edges, int[] price) {

        sum1 = new long[n];
        sum2 = new long[n];

        g = new HashMap<>();
        for(int[]e : edges){
            g.putIfAbsent(e[0], new HashSet<>());
            g.get(e[0]).add(e[1]);
            g.putIfAbsent(e[1], new HashSet<>());
            g.get(e[1]).add(e[0]);
        }

        dfs(0, -1, price);
        dfs2(0, -1, price);

        return res;

    }

    private void dfs(int cur, int parent,  int[] price){

        if(g.get(cur).size()==1 && new ArrayList<>(g.get(cur)).get(0)==parent){
            // no child
          sum1[cur]=0;
          sum2[cur]=price[cur];
          return;
        }

        long maxSum1 = 0, maxSum2=0;
        for(int next : g.get(cur)){
            if(next==parent) continue;
            dfs(next, cur, price);
            maxSum1 = Math.max(maxSum1, sum1[next]);
            maxSum2 = Math.max(maxSum2, sum2[next]);
        }

        sum1[cur] = maxSum1 + price[cur];
        sum2[cur] = maxSum2 + price[cur];
    }


    private void dfs2(int cur, int parent,  int[] price){

        List<long[]> arr1 = new ArrayList<>(); // sumVal, childNodeId
        List<long[]> arr2 = new ArrayList<>();

        long ans = sum1[cur];
        if(cur!=0) ans = Math.max(ans, sum2[cur]);

        for(int next : g.get(cur)){
            if(next==parent) continue;

            arr1.add(new long[] {sum1[next], next});
            arr2.add(new long[] {sum2[next], next});
        }

        Collections.sort(arr1, (a,b)->a[0]-b[0]);
        Collections.sort(arr2, (a,b)->a[0]-b[0]);

        if(arr1.size()>=2){

            if(arr1.get(0)[1]!=arr2.get(0)[1]){
                ans = Math.max(ans ,arr1.get(0)[0] + arr2.get(0)[0] + price[cur]);
            }else
                ans = Math.max(ans, Math.max(arr.get(0)[0] + arr2.get(1)[0], arr1.get(1)[0]+arr2.get(0)[0]) + price[cur]);
        }


        res = Math.max(res, ans);
    }
}