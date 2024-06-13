// https://leetcode.com/problems/minimum-height-trees

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        

        List<Integer> res = new ArrayList<>();

        if(n==1){
            res.add(0);
            return res;
        }

        HashMap<Integer, Set<Integer>> g = new HashMap<>();

        int[] deg = new int[n];
        for(int[] e : edges){

            deg[e[0]]++;
            deg[e[1]]++;
            g.putIfAbsent(e[0], new HashSet<>());
            g.putIfAbsent(e[1], new HashSet<>());
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);


        }


        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(deg[i]==1){
                q.offer(i);
                set.add(i);
            }
        }


        
        int dep = 0;
        while(!q.isEmpty()){
            int siz = q.size();
            dep++;

            res = new ArrayList<>();
            while(siz-->0){
                
                int p = q.poll();
                res.add(p);

                for(int next : g.get(p)){

                    if(!set.contains(next)){
                        q.offer(next);
                        set.add(next);
                    }
                }
            }
        }

        return res;
    }
}