// https://leetcode.com/problems/find-the-most-competitive-subsequence

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int len = nums.length;
        int del = len-k;
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<len; i++){

            while(!stk.isEmpty() && del>0 && nums[i]<stk.peek()){
                stk.pop();
                del--;
            }
            stk.push(nums[i]);
        }

        while(!stk.isEmpty() && del>0){
            stk.pop();
            del--;
        }

        int[] res = new int[stk.size()];
        for(int i=res.length-1; i>=0; i--){
            res[i] = stk.pop();
        }

        return res;
    }
}