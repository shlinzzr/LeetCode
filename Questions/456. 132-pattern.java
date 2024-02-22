// https://leetcode.com/problems/132-pattern

class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;

        int[] leftMin = new int[len];

        int min = Integer.MAX_VALUE;
        for(int i=0; i<len; i++){
            min = Math.min(min, nums[i]);
            leftMin[i] = min;
        }

        Stack<Integer> st = new Stack<>();
        int second = Integer.MIN_VALUE;
        for(int i=len-1; i>=0; i--){
            
            while(!st.isEmpty() && nums[i]>st.peek()){
                second = st.pop();

                if(leftMin[i]<second)
                    return true;
            }

            st.push(nums[i]);
        }



        return false;
    }
}