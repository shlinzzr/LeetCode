// https://leetcode.com/problems/subsets-ii

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new LinkedHashSet<>();
        helper(nums, res, new ArrayList<>(), 0);
        return new ArrayList<>(res); 
    }

    private void helper(int[] nums, Set<List<Integer>> res, List<Integer>curr, int st){
        List<Integer> add = new ArrayList<>(curr);
        Collections.sort(add);
        res.add(add);

        for(int i=st; i<nums.length; i++){
            curr.add(nums[i]);
            helper(nums, res, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
}

/*
[4,4,1],[4,4,1,4],[4,1],
[[],[1],[1,4],[4,1,4],[4,4,4,1],[4,4,4,1,4],[4],[4,4],[4,4,4],[4,4,4,4],

[[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]


*/