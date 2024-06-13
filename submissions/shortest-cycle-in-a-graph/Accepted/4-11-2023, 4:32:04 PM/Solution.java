// https://leetcode.com/problems/shortest-cycle-in-a-graph

class Solution  {
      public int findShortestCycle(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map  = new HashMap<>();
        for(int[] e : edges){
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        int minCycle = Integer.MAX_VALUE;
        for (int st = 0; st < n; st++) {
            int[] distance = new int[n];
            Arrays.fill(distance, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(st);
            distance[st] = 0;
            
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int next : map.getOrDefault(curr, new ArrayList<>())) {
                    if (distance[next] == -1) {
                        distance[next] = distance[curr] + 1;
                        queue.offer(next);
                    } else if (next!= st && distance[next] >= distance[curr]) {
                        minCycle = Math.min(minCycle, distance[curr] + distance[next] + 1);
                    }
                }
            }
        }

        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
}