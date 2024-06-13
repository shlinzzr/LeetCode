// https://leetcode.com/problems/non-decreasing-subsequences

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {

        // Arrays.sort(nums);

        Set<List<Integer>> res =new HashSet<>();

        int len = nums.length;

        helper(nums, res,  new ArrayList<>(), 0);

        return new ArrayList<>(res);
    }

    private void helper(int[] nums, Set<List<Integer>> res, List<Integer> curr, int st){

        if(curr.size()>1){
            res.add(new ArrayList<>(curr));
        }

        int len = nums.length;
        for(int i=st; i<len; i++){

            if(curr.isEmpty() || curr.get(curr.size()-1)<=nums[i]){
                curr.add(nums[i]);
                helper(nums, res, curr, i+1);
                curr.remove(curr.size()-1);
            }   
        }


    }

}