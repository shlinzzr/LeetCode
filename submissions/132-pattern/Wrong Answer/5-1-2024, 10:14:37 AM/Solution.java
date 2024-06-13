// https://leetcode.com/problems/132-pattern

class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        int[] leftMin = new int[len];

        int curMin = nums[0];
        for(int i=1; i<len ;i++){
            leftMin[i] = Math.min(nums[i], leftMin[i-1]);
        }

        Stack<Integer> st = new Stack<>();
        int[] prevGreater = new int[len];

        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && nums[i] > nums[st.peek()]){


                int p = st.pop();
                prevGreater[p] = i;

                if(leftMin[i] < nums[p]) return true;
            }
            st.push(i);
        }
        return false;
    }
}