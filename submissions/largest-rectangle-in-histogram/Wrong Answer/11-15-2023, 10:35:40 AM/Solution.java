// https://leetcode.com/problems/largest-rectangle-in-histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;

        int[] nextSmaller = new int[len];
        Stack<Integer> st = new Stack<>();

       // 123456
       //
        Arrays.fill(nextSmaller, len);

        for(int i=0; i<len; i++){

            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        int[] prevSmaller = new int[len];
        Arrays.fill(prevSmaller, 0);
        st.clear();
        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }


        int res = 0;
        for(int i=0; i<len; i++){
            res = Math.max(res, (nextSmaller[i]-prevSmaller[i]-1)*heights[i]);
        }

        return res;

    }
}