// https://leetcode.com/problems/number-of-valid-subarrays

class Solution {
    // find next smaller element

    public int validSubarrays(int[] nums) {
        int len =nums.length;
        int res = 0;

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<len; i++){

            while(!st.isEmpty() && nums[i]<nums[st.peek()]){
                res += i-st.pop();
            }

            st.push(i);
        }

        while(!st.isEmpty()){
            res += len-st.pop();
        }

        

        return res;

    }




}