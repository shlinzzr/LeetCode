// https://leetcode.com/problems/trapping-rain-water

class Solution {
    public int trap(int[] height) {
        int len = height.length;

        int[] left = new int[len];
        int[] right = new int[len];
        // Arrays.fill(right, -1);
        // Arrays.fill(left, len);

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<len; i++){
            while(!st.isEmpty() && height[st.peek()] >= height[i]){
                right[st.pop()] = i;
            }
            st.push(i);
        }
        st = new Stack<>();
        for(int i=len-1; i>=0; i--){

            while(!st.isEmpty() && height[st.peek()] >= height[i]){
                left[st.pop()] = i;
            }
            st.push(i);
        }

        int res = 0;

        for(int i=0; i<len; i++){

            int max = Math.min(height[left[i]], height[right[i]]);

            if(max==0)
                continue;

            for(int j=left[i]+1; j<right[i]; j++){
                res += max-height[j];
            }
            if(right[i]!=0)
                i=right[i];
        }

        return res;


    }
}