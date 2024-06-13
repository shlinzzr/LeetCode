// https://leetcode.com/problems/smallest-missing-genetic-value-in-each-subtree

class Solution {
//     List<Set<Integer>> setList = new ArrayList<>();
//     int[] setIdx = new int[100005];
    int[] res;

    Map<Integer, List<Integer>> g = new HashMap<>();
    Map<Integer, Set<Integer>> v = new HashMap<>();

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {

        int len = parents.length;
        res = new int[len];
        for (int i=1; i<len; i++)   {
            g.putIfAbsent(parents[i], new ArrayList<>());
            g.get(parents[i]).add(i);
        }     

        dfs(0, nums);
        return res;
    }

    private void dfs(int node, int[] nums){
        if(!g.containsKey(node)){ // leaf
            v.putIfAbsent(node, new HashSet<>(Arrays.asList(nums[node])));
            res[node] = nums[node]==1?2:1;
        }
        else{   
            for (int child: g.get(node))
                dfs(child, nums);

            int maxSetSize = 0;
            int maxSetIdx = 0;
            for (int child: g.get(node))
            {
                if(v.getOrDefault(child, new HashSet<>()).size()> maxSetSize){
                    maxSetSize = v.get(child).size();
                    maxSetIdx = child;
                }
            }

            v.put(node, v.get(maxSetIdx));

            for (int child: g.get(node))
            {
                if (child == maxSetIdx) continue;
                for(int x : v.getOrDefault(child, new HashSet<>())){
                    v.putIfAbsent(maxSetIdx, new HashSet<>());
                    v.get(maxSetIdx).add(x);
                }
            }

            v.putIfAbsent(maxSetIdx, new HashSet<>());
            v.get(maxSetIdx).add(nums[node]);

            int maxMissing = 0;            
            for (int child: g.get(node))    
                maxMissing = Math.max(maxMissing, res[child]);
            int x = maxMissing;

            while(v.get(maxSetIdx).contains(x))
                x++;
            res[node] = x;
        }

    }
}