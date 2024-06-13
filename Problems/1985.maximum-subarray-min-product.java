// https://leetcode.com/problems/maximum-subarray-min-product

class Solution {
    public int maxSumMinProduct(int[] nums) {
        int len = nums.length;
        int M = (int)1e9+7;

        long[] presum =  new long[len];
        for(int i=0; i<len; i++){
            presum[i] = i==0 ?  nums[0] : (presum[i-1] + nums[i]);
        }

       
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
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        long max = 0l;

        for(int i=0; i<len; i++){
   
            long prev = prevSmaller[i]==-1 ? 0 : presum[prevSmaller[i]];
            long next = presum[nextSmaller[i]-1];
            long val = ((long)nums[i] * (next - prev));
            max = Math.max(max, val);
        }

        return (int)(max%M);



    }
}