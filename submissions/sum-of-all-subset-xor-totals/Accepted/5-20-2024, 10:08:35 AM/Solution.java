// https://leetcode.com/problems/sum-of-all-subset-xor-totals

class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        helper(nums, new ArrayList<>(), list, 0);

        
        int res= 0 ;
        for(List<Integer> sub : list){
            int xor = 0;
            for(int n : sub){
                xor^=n;
            }
            res+=xor;
        }
        return res;
        
    }

    private void helper(int[] nums, List<Integer> curr, List<List<Integer>> list, int idx ){

        list.add(new ArrayList<>(curr));

        for(int i=idx; i<nums.length; i++){

            curr.add(nums[i]);
            helper(nums, curr, list, i+1);
            curr.remove(curr.size()-1);
        }



    }
}