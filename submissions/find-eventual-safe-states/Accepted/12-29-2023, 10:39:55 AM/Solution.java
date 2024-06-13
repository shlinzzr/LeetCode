// https://leetcode.com/problems/find-eventual-safe-states

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> res = new HashSet<>();

        // HashMap<Integer, Set<Integer>> g= new HashMap<>();
        HashMap<Integer, Set<Integer>> parent= new HashMap<>();

        int len = graph.length;
        int[] outdeg = new int[len];

        Queue<Integer> q = new LinkedList<>();

        for(int i =0; i<len; i++){
            int[] adj = graph[i];
            // g.putIfAbsent(i, new HashSet<>());

            if(adj.length==0) q.offer(i);


            for(int a: adj){
                parent.putIfAbsent(a, new HashSet<>());
                parent.get(a).add(i);
                // g.get(i).add(a);
                outdeg[i]++;
            }
        }

        
        // for(int i=0; i<len ;i++){
        //     int o = outdeg[i];
        //     // System.out.print(o+",");
        //     if(o==0){
        //         q.offer(i);
        //         res.add(i);
        //     }
        // }

        while(!q.isEmpty()){

            int cur = q.poll();
            res.add(cur);

            for(int prev: parent.getOrDefault(cur, new HashSet<>())){
                outdeg[prev]--;
                if(outdeg[prev]==0)
                    q.offer(prev);
            }
                    

            // boolean allsave = true;
            // for(int next : g.get(cur)){
            //     if(!res.contains(next)){
            //         allsave = false;
            //     }
            // }

            // // System.out.println(cur + " " + allsave);

            // if(allsave){
            //     res.add(cur);
            //     for(int prev: parent.getOrDefault(cur, new HashSet<>()))
            //         q.offer(prev);
            // } 
        }
        
        List<Integer> list = new ArrayList<>(res);
        Collections.sort(list);
        return list;


    }
}