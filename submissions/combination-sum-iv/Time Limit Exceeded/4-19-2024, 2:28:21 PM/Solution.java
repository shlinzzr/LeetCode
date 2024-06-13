// https://leetcode.com/problems/combination-sum-iv

class Solution {
    public int combinationSum4(int[] nums, int target) {

        Set<List<Integer>> set = new HashSet<>();
        List<Integer> cur = new ArrayList<>();

        helper(nums, target, set, cur);

        return set.size();
    }

    private void helper(int[] nums, int target, Set<List<Integer>> set, List<Integer> cur){

        if(target==0){
            set.add(new ArrayList<>(cur));
            return;
        }

        for(int i=0; i<nums.length; i++){
            int val = nums[i];

            if(target-val>=0){
                cur.add(val);
                helper(nums, target-val, set, cur);
                cur.remove(cur.size()-1);
            }
        }   
    }
}