// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital

class Solution {
    long res = 0;
    int seats = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        this.seats = seats;
        int n = roads.length + 1;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        dfs(graph, 0, 0);
        return res;
    }

    private int dfs(List<Integer>[] graph, int prev, int cur) {
        int people = 1;
        for (int next : graph[cur]) {
            if (next == prev) continue;
            people += dfs(graph, cur, next);
        }
        if (cur != 0) res += Math.ceil(people * 1.0 / seats);
        return people;
    }
}