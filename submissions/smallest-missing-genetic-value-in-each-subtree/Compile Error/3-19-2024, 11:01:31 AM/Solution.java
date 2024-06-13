// https://leetcode.com/problems/smallest-missing-genetic-value-in-each-subtree

class Solution {

    Map<Integer, List<Integer>> map ;
    int[] res = new int[len];
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int len = parents.length;

        
        vmap = new HashMap<>();
        map = new HashMap<>();
        for(int i=0; i<len; i++){
            map.putIfAbsent(parents[i], new ArrayList<>());
            map.get(parents[i]).add(i);

            
        }

        helper(nums, 0);

    }

    private Set<Integer> helper( int[] nums, int idx){

        if(map.get(idx)==null){
            if(nums[idx]!=1)
                res[idx] = 1;
            else 
                res[idx] = 2;
            Set<Integer> set = new TreeSet<>();
            set.add(nums[idx]);
            return set;
        }

        Set<Integer> all = new TreeSet<>();

        for(int child : map.get(idx)){
            
            Set<Integer> sub = helper(nums, child);
            all.
        }



    }
}