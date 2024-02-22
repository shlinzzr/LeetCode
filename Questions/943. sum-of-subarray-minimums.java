// https://leetcode.com/problems/sum-of-subarray-minimums

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int M = (int) 1e9+7;
        int len = arr.length;
        
        int[] prevSmaller = new int[len];
        Arrays.fill(prevSmaller, -1);

        int[] nextSmaller = new int[len];
        Arrays.fill(nextSmaller, len);

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        st.clear();
        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        long ret = 0;
        for (int i=0; i<len; i++)
        {
            long count = (i-prevSmaller[i])*(nextSmaller[i]-i) % M;
            ret = (ret+arr[i]*count) %M;
        }
        return (int)ret;

        
    }
}