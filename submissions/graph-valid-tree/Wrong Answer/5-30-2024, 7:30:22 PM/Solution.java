// https://leetcode.com/problems/graph-valid-tree

class Solution {

    Map<Integer, List<Integer>> adjs;
    public boolean validTree(int n, int[][] edges) {
        

        // tree mean's that no cycle
        // define " what is  valid tree "
        // recur, or union find ?


        
        adjs = new HashMap<>();
        for(int[] e : edges){
            adjs.putIfAbsent(e[0], new ArrayList<>());
            adjs.get(e[0]).add(e[1]);
            adjs.putIfAbsent(e[1], new ArrayList<>());
            adjs.get(e[1]).add(e[0]);
        }

        // Queue<Integer> q = new LinkedList<>();
        for(int key : adjs.keySet()){
            if(adjs.get(key).size()==1){ //edge
                Set<Integer> seen = new HashSet<>();
                seen.add(key);
                seen.add(adjs.get(key).get(0));
                if(helper(key, adjs.get(key).get(0), seen)==false)
                    return false;
            }
        }
        return true;

    }

    private boolean helper(int parent, int curr, Set<Integer> seen){
        
        for(int next: adjs.get(curr)){
            if(next==parent) continue;
            if(seen.add(next)==false) return false;
            boolean rt = helper(curr, next, seen);
            if(rt==false) return false;
        }

        return true;

    }
}

        // Set<Integer> seen = new HashSet<>();

        // while(!q.isEmpty()){
        //     int size = q.size();
        //     while(size-->0){
        //         int p = q.poll();

        //         if(seen.contains(p)) return false;

        //         for(int adj : adjs.get(p)){

        //         }




        //     }
        // }

        
        

        