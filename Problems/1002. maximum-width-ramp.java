// https://leetcode.com/problems/maximum-width-ramp

class Solution {
    public int maxWidthRamp(int[] nums) {
        int len = nums.length;
        Stack<Integer> st = new Stack<>();


        // find i candiate , make stack desc
        for(int i=0; i<len; i++){
            if(st.isEmpty() || nums[st.peek()]>nums[i]){
                st.push(i);
            }
        }


        int max =0 ;
        // find j match with i from back, max = (j-i)
        for(int j=len-1; j>=0; j--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[j]){
                max = Math.max(max, j-st.pop());
            }
        }

        return max;
    }
}