// https://leetcode.com/problems/arithmetic-slices-ii-subsequence

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;

        boolean[] seen = new boolean[len];
        List<List<Long>> res = new ArrayList<>();
        helper(nums, 0, seen, new ArrayList<>(), res);

        return res.size();
    }

    private void helper(int[] nums, int st, boolean[] seen, List<Long> list, List<List<Long>> res){

        if(list.size()>=3){
            res.add(new ArrayList<>(list));
        }

        for(int i=st; i<nums.length; i++){

            if(seen[i]==false){
             

                if(list.isEmpty() || list.size()==1 || (nums[i]-list.get(list.size()-1)== list.get(list.size()-1)- list.get(list.size()-2))){
                    seen[i]=true;
                    list.add((long)nums[i]);
                    helper(nums, i+1, seen, list, res);
                    list.remove(list.size()-1);
                    seen[i]=false;
                }
                
            }
        }

    }
}