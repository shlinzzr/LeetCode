// https://leetcode.com/problems/minimum-height-trees

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }

        Map<Integer, Set<Integer>> map= new HashMap<>();
        int[] deg = new int[n];
        for(int[] e : edges){
            deg[e[0]]++;
            deg[e[1]]++;
            map.putIfAbsent(e[0], new HashSet<>());
            map.putIfAbsent(e[1], new HashSet<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(deg[i]==1){
                q.offer(i);
                deg[i]--;
            }
        }

        int cnt=n;

        while(cnt>2){
            int size = q.size();
            cnt -= size;
            while(size-->0){
                int p = q.poll();
                for(int next : map.get(p)){
                    deg[next]--;
                    if(deg[next]==1){
                        q.offer(next);
                        deg[next]--;
                    }
                }
            }
        }

        return new ArrayList<>(q);


        
    }
}