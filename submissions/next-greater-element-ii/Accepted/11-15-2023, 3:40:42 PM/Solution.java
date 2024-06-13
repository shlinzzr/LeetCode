// https://leetcode.com/problems/next-greater-element-ii

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] tmp = new int[len*2];
        System.arraycopy(nums, 0, tmp, 0, len);
        System.arraycopy(nums, 0, tmp, len, len);

        
        int[] nextGreater = new int[len*2];
        Arrays.fill(nextGreater, -1);

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<2*len; i++){

            while(!st.isEmpty() && tmp[st.peek()]<tmp[i]){
                nextGreater[st.pop()] = tmp[i];
            }
            st.push(i);
        }

        int[] res = new int[len];
        
        for(int i=0; i<len; i++){
            res[i] = nextGreater[i];
        }

        return res;

    }
}