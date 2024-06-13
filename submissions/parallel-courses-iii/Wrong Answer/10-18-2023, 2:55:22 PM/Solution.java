// https://leetcode.com/problems/parallel-courses-iii

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();

        for(int i=1; i<=n; i++){
            indegree.put(i, 0);
        }


        for(int i=0; i<relations.length; i++){
            int prev = relations[i][0];
            int next = relations[i][1];

            map.putIfAbsent(prev, new HashSet<>());
            map.get(prev).add(next);
            indegree.put(next, indegree.getOrDefault(next, 0)+1);
        }

        Set<Integer> list = new HashSet<>();
        for(Map.Entry<Integer, Integer> en : indegree.entrySet()){

            System.out.println(en.getKey() + " " + en.getValue());

            if(en.getValue()==0){
                list.add(en.getKey());
            }
        }

        



        int sum = 0;
        while(n>0){
            
            int max = 0;
            Set<Integer> next = new HashSet<>();
            for(int node : list){
                n--;
                max = Math.max(max, time[node-1]);
                for(int nxt  : map.getOrDefault(node, new HashSet<>())){
                    indegree.put(nxt, indegree.get(nxt)-1);
                    if(indegree.get(nxt)==0)
                        next.add(nxt);
                }
            }
            sum += max;
            list = next;
        }

        return sum;
    


    }
}