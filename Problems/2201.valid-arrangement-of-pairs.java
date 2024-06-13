// https://leetcode.com/problems/valid-arrangement-of-pairs

class Solution {
    // map to track all outcoming edges for given vertex
    HashMap<Integer, Stack<Integer>> map = new HashMap<>();

    public int[][] validArrangement(int[][] pairs) {
        
        // map to calculate outdegree - indegree
        HashMap<Integer, Integer> indeg = new HashMap<>();

        for (int[] p : pairs) {
            map.putIfAbsent(p[0], new Stack<>());
            map.get(p[0]).push(p[1]);

            indeg.put(p[1], indeg.getOrDefault(p[1], 0)+1);
            indeg.put(p[0], indeg.getOrDefault(p[0], 0)-1);
        }

        /*
            Based on task description our graph at least has Eulerian path
            or possible even circle.
            If it has circle, we can start from any node (let's take the first vertex)
            If the graph has Eulerian path only, in this case there will be exactly
            one vertex with degree -1, this will be our start node.
        */
        int start = pairs[0][0];
        for (int[] p : pairs) {
            if (indeg.get(p[0]) == -1) {
                start = p[0];
                break;
            }
        }

        // build the path in reverse order
        List<Integer> path = new ArrayList<>();        
        dfs(start, path);
        // reverse it
        Collections.reverse(path);

        int[][] res = new int[pairs.length][2];

        // build the result
        for (int i = 0; i < path.size()-1; i++) {
            res[i][0] = path.get(i);
            res[i][1] = path.get(i+1);
        }

        return res;
    }

    public void dfs(int cur, List<Integer> path) {
        while (map.containsKey(cur) && map.get(cur).size() > 0) {
            dfs(map.get(cur).pop(), path);
        }
        path.add(cur);
    }
}