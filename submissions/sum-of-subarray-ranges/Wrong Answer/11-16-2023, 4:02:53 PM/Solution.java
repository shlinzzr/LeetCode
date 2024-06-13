// https://leetcode.com/problems/sum-of-subarray-ranges

class Solution {
    public long subArrayRanges(int[] nums) {
        int len = nums.length;
       
        Stack<Integer> st = new Stack<>();

        int[] nextSmaller = new int[len];
        Arrays.fill(nextSmaller, len);
        for(int i=0; i<len; i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        st.clear();

        int[] prevSmaller = new int[len];
        Arrays.fill(prevSmaller, -1);
        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }


        st.clear();
        int[] nextGreater = new int[len];
        Arrays.fill(nextGreater, len);
        for(int i=0; i<len; i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                nextGreater[st.pop()] = i;
            }
            st.push(i);
        }

        st.clear();
        int[] prevGreater = new int[len];
        Arrays.fill(prevGreater, -1);
        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                prevGreater[st.pop()] = i;
            }
            st.push(i);
        }



        long ret = 0;
        for (int i=0; i<len; i++)
        {
            int l = prevGreater[i];
            int r = nextGreater[i];
            ret -= (long)nums[i]*(i-l)*(r-i);
        }
        for (int i=0; i<len; i++)
        {
            int l = prevSmaller[i];
            int r = nextSmaller[i];
            ret += (long)nums[i]*(i-l)*(r-i);
        }
        return ret;                

        

    }
}