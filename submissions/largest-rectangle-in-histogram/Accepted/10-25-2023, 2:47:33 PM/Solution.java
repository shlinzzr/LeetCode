// https://leetcode.com/problems/largest-rectangle-in-histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int len = heights.length;
        int[] nextSmaller = new int[len];
        int[] prevSmaller = new int[len];
        Arrays.fill(nextSmaller, len);
        Arrays.fill(prevSmaller, -1);
        


        Stack<Integer> st =new Stack<>();

        for(int i=0; i<len ;i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i] ){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }


        int max = 0;
        for(int i=0; i<len; i++){
            max = Math.max(max, (nextSmaller[i] - prevSmaller[i]-1) * heights[i]);
        }


        return max;


     


    }
}