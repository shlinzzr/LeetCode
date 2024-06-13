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

           
        // // find leaves node
        // List<Integer> leaves = new ArrayList<>();
        // for(Map.Entry<Integer, Set<Integer>> en : g.entrySet()){
        //     if(en.getValue().size()==1 ){
        //         int leaf = en.getKey();
        //         leaves.add(leaf);
        //     }
        // } 
        
        // // start with leaves to reduce
        // while(n>2){ // <=== this is the key
            
        //     n-=leaves.size();
            
        //     List<Integer> next = new ArrayList<>();
            
        //     for(int leaf : leaves){
        //         int parent = new ArrayList<>(g.get(leaf)).get(0);
        //         g.get(parent).remove(leaf);
        //         if(g.get(parent).size()==1)
        //             next.add(parent);
        //     }
            
        //     leaves = next;
        // }
        
        // return leaves;

        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(deg[i]==1){
                q.offer(i);
                set.add(i);
            }
        }
         System.out.println(new ArrayList<>(q));


        
        int dep = 0;
        // while(!q.isEmpty()){
        while(n>2){
            int siz = q.size();
            n-=siz;
            dep++;
            res = new ArrayList<>();
            while(siz-->0){
                
                int p = q.poll();

                for(int next : g.get(p)){
                    deg[next]--;
                    if(!set.contains(next) && deg[next]==1){
                        q.offer(next);
                        set.add(next);
                        res.add(next);
                    }
                }
            }
            System.out.println(new ArrayList<>(q));
            
        }

        return res;
    }
}