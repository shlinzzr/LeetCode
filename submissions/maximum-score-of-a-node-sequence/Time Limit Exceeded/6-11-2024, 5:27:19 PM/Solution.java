// https://leetcode.com/problems/maximum-score-of-a-node-sequence

class Solution {

    int max= -1;
    Map<Integer, Set<Integer>> map ;
    public int maximumScore(int[] scores, int[][] edges) {

        int n = scores.length;

        map = new HashMap<>();
        for(int[] e: edges){
            map.putIfAbsent(e[0], new HashSet<>());
            map.get(e[0]).add(e[1]);
            map.putIfAbsent(e[1], new HashSet<>());
            map.get(e[1]).add(e[0]);
        }
        

        for(int i=0; i<n; i++){

            LinkedHashSet<Integer> seen = new LinkedHashSet<>();
            seen.add(i);
            bfs(scores, -1, i, 0, seen);
        }

        return max;
        
    }

    private void bfs(int[] scores, int parent, int i, int sum, LinkedHashSet<Integer> seen){

        sum += scores[i];

        if(sum > max && seen.size()==4){
            max = Math.max(max, sum);
            System.out.println(seen);
            return ;
        }


        for(int next : map.getOrDefault(i, new HashSet<>())){
            if(parent==next || seen.contains(next)) continue;
            seen.add(next);
            bfs(scores, i, next, sum, seen);
            seen.remove(next);
        }

        sum -= scores[i];
    }
}