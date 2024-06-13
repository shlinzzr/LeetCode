// https://leetcode.com/problems/132-pattern

class Solution {
    public boolean find132pattern(int[] nums) {

        //    x x x x x
        //    1 2 3 4
        // ng 2 3 4 x
        // pv x x x x 

        //     3 1 4 2
        // ng  4 2 x x
        // pv  x 3 x 3

        int len = nums.length;

        Integer[] nextSmaller = new Integer[len];

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<len; i++){

            while(!st.isEmpty() && nums[st.peek()]> nums[i]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        st.clear();

        Integer[] prevSmaller = new Integer[len];
        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]> nums[i]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        for(int i=0; i<len; i++){

            if(prevSmaller[i]!=null && nextSmaller[i]!=null && nums[prevSmaller[i]]< nums[ nextSmaller[i]])
                return true;

        }

        return false;
        
    }
}