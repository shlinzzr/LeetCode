// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        
        helper(nums, res, new ArrayList<>(), new boolean[len]);

        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> curr, boolean[] seen){

        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!seen[i]){
                seen[i]=true;
                curr.add(nums[i]);
                helper(nums, res, curr, seen);
                seen[i]=false;
                curr.remove(curr.size()-1);
            }
        }
    }
}