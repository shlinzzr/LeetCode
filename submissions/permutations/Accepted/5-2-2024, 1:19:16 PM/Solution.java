// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  res= new ArrayList<>();
        int len = nums.length;
        boolean[] seen = new boolean[len];
        helper(nums, new ArrayList<>(), seen, res);
        return res;
    }

    private void helper(int[] nums, List<Integer> curr, boolean[]seen, List<List<Integer>>  res){

        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++){

            if(seen[i]) continue;
            seen[i] = true;
            curr.add(nums[i]);
            helper(nums, curr, seen, res);
            curr.remove(curr.size()-1);
            seen[i] = false;
        }

    }
}