// https://leetcode.com/problems/maximum-subarray-min-product

class Solution {
    public int maxSumMinProduct(int[] nums) {
        int len = nums.length;

        int[] presum =  new int[len];
        for(int i=0; i<len; i++){
            presum[i] = i==0 ? nums[0] : presum[i-1] + nums[i];
        }

        int M = (int)1e9+7;

        Stack<Integer> st = new Stack<>();

        int[] nextSmaller = new int[len];
        Arrays.fill(nextSmaller, len);
        for(int i=0; i<len; i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        int[] prevSmaller = new int[len];
        Arrays.fill(prevSmaller, -1);
        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        long max = Integer.MIN_VALUE;

        for(int i=0; i<len; i++){
            long prev = prevSmaller[i]==-1 ? 0 : presum[prevSmaller[i]];
            long val = nums[i] * (presum[nextSmaller[i]-1] - prev)%M;
            max = Math.max(max, val);
        }

        return (int)max;



    }
}