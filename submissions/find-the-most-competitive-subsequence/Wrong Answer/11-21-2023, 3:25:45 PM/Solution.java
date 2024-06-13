// https://leetcode.com/problems/find-the-most-competitive-subsequence

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int len = nums.length;

        if(k==len)
            return new int[0];


        k = len-k;


        Stack<Integer> st = new Stack<>();

        for(int i=0; i<len; i++){
            while(k>0 && !st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
                k--;
            }
            st.push(i);
        }

        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }


        int[] res = new int[st.size()];
        int idx = 0;
        for(int i : st){
            res[idx++]=nums[i];
        }

        return res;

    }
}