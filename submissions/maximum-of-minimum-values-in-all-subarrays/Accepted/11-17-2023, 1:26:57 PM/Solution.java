// https://leetcode.com/problems/maximum-of-minimum-values-in-all-subarrays

class Solution {
    public int[] findMaximums(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= len; i++) {

            while (!st.isEmpty() && (i == len || nums[st.peek()] >= nums[i])) {
                int j = st.pop(), k = i - 1;
                if (!st.isEmpty())
                    k -= st.peek() + 1;
                res[k] = Math.max(res[k], nums[j]);
            }
            st.push(i);
        }    
        for (int i = len-1; i > 0; i--)
            res[i - 1] = Math.max(res[i - 1], res[i]);    
            
        return res;
    }
}