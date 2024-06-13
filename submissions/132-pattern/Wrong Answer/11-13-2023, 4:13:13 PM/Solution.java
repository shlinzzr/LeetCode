// https://leetcode.com/problems/132-pattern

class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<len; i++){

            if(st.isEmpty()){
                st.push(nums[i]);
                continue;
            }else{

                while(!st.isEmpty() && nums[i]<st.peek()){
                    st.pop();
                }
                st.push(nums[i]);

            }

        }

        if(st.size()>1 && st.size()!=len){
            return true;

        }

        return false;

    }
}