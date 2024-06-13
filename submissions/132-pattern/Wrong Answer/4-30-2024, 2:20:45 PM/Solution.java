// https://leetcode.com/problems/132-pattern

class Solution {
    public boolean find132pattern(int[] nums) {

        //    x x x x x
        //    1 2 3 4
        // ng 2 3 4 x
        // pv x x x x 

        //     3 1 4 2
        // ns  1 x 2 x
        // pv  x x 1 1

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
            if(prevSmaller[i]!=null && nextSmaller[i]!=null){

                Integer idx = prevSmaller[i];
                int next = nums[nextSmaller[i]];

                System.out.println(i + " " + nums[idx] + " " + next);

                if(nums[idx]<next) return true;

                while(idx!=null && nums[idx]>next){
                    idx = prevSmaller[idx];
                    if(idx!=null && nums[idx]<next) return true;
                }

            }

        }

        return false;
        
    }
}