// https://leetcode.com/problems/subarray-with-elements-greater-than-varying-threshold

class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int len = nums.length;

        int[] nextSmaller = new int[len];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(nextSmaller, len);

        for(int i=0; i<len; i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        int[] prevSmaller = new int[len];
        Arrays.fill(prevSmaller, -1);
        st.clear();
        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        for(int i=0; i<len; i++){

            int area = (nextSmaller[i]-prevSmaller[i]-1)*nums[i];
            if(area>threshold)
                return nextSmaller[i]-prevSmaller[i]-1;
        }

        return -1;
    }
}