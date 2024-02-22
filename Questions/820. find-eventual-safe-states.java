// https://leetcode.com/problems/find-eventual-safe-states

class Solution {

    int[] flag; //0 : not process yet,  1: true, 2:false
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> res = new ArrayList<>();


        int len = graph.length;
        flag = new int[len];
        
        // // solution 1 dfs find cycle
        for(int i=0; i<len; i++){
            if(dfs(i, graph))
                res.add(i);
        }
        return res;
    }


    private boolean dfs(int i, int[][] graph){
        
        if(flag[i]==1) return true;
        if(flag[i]==2) return false;
        
        flag[i]=2;
        for(int next : graph[i]){
            if(dfs(next, graph)==false)
                return false;
        }
        flag[i]=1;
        return true;
        
        
        
    }

    //     Set<Integer> res = new HashSet<>();

    //     // HashMap<Integer, Set<Integer>> g= new HashMap<>();
    //     HashMap<Integer, Set<Integer>> parent= new HashMap<>();

    //     int len = graph.length;
    //     int[] outdeg = new int[len];

    //     Queue<Integer> q = new LinkedList<>();

    //     for(int i =0; i<len; i++){
    //         int[] adj = graph[i];
    //         // g.putIfAbsent(i, new HashSet<>());

    //         if(adj.length==0) q.offer(i);


    //         for(int a: adj){
    //             parent.putIfAbsent(a, new HashSet<>());
    //             parent.get(a).add(i);
    //             // g.get(i).add(a);
    //             outdeg[i]++;
    //         }
    //     }

        
    //     // for(int i=0; i<len ;i++){
    //     //     int o = outdeg[i];
    //     //     // System.out.print(o+",");
    //     //     if(o==0){
    //     //         q.offer(i);
    //     //         res.add(i);
    //     //     }
    //     // }

    //     while(!q.isEmpty()){

    //         int cur = q.poll();
    //         res.add(cur);

    //         for(int prev: parent.getOrDefault(cur, new HashSet<>())){
    //             outdeg[prev]--;
    //             if(outdeg[prev]==0)
    //                 q.offer(prev);
    //         }
                    

    //         // boolean allsave = true;
    //         // for(int next : g.get(cur)){
    //         //     if(!res.contains(next)){
    //         //         allsave = false;
    //         //     }
    //         // }

    //         // // System.out.println(cur + " " + allsave);

    //         // if(allsave){
    //         //     res.add(cur);
    //         //     for(int prev: parent.getOrDefault(cur, new HashSet<>()))
    //         //         q.offer(prev);
    //         // } 
    //     }
        
    //     List<Integer> list = new ArrayList<>(res);
    //     Collections.sort(list);
    //     return list;


    // }
}