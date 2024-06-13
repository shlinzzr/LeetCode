// https://leetcode.com/problems/missing-ranges

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {

        int len = nums.length;

        List<List<Integer>> res= new ArrayList<>();
        if(len==0) {
            List<Integer> list = new ArrayList<>();
            list.add(lower);
            list.add(upper);
            res.add(list);
            return res;
        }

        if(nums[0]!=lower) {
            List<Integer> list = new ArrayList<>();
            list.add(lower);
            list.add(nums[0]-1);
            res.add(list);
        }

        for(int i=0; i<len-1; i++){

            int curr = nums[i];
            int next = nums[i+1];

            if(curr+1==next) continue;

            int left=curr+1;
            int right = next-1;
            List<Integer> list = new ArrayList<>();
            list.add(left);
            list.add(right);
            res.add(list);
        }

        if(nums[len-1]!=upper){
            List<Integer> list = new ArrayList<>();
            list.add(nums[len-1]+1);
            list.add(upper);
            res.add(list);
        }

        return res;

        
    }
}