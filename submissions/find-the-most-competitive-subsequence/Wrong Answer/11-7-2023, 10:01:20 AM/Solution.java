// https://leetcode.com/problems/find-the-most-competitive-subsequence

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int len = nums.length;
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<len; i++){

            while(!stk.isEmpty() && k>0 && nums[i]<stk.peek()){
                stk.pop();
                k--;
            }
            stk.push(nums[i]);
        }

        while(!stk.isEmpty() && k>0){
            stk.pop();
            k--;
        }

        int[] res = new int[stk.size()];
        for(int i=res.length-1; i>=0; i--){
            res[i] = stk.pop();
        }

        return res;
    }
}