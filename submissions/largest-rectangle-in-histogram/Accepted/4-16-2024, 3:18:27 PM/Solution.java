// https://leetcode.com/problems/largest-rectangle-in-histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;

        int[] nextSmaller = new int[len];
        Arrays.fill(nextSmaller, len);

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len; i++){
            int h = heights[i];

            if(!st.isEmpty()){
                while(!st.isEmpty() && heights[st.peek()]>h){
                    nextSmaller[st.pop()] = i;
                }
            }
            st.push(i);
        }
        st.clear();

        int[] prevSmaller = new int[len];
        Arrays.fill(prevSmaller, -1);
        for(int i=len-1; i>=0; i--){
            
            int h = heights[i];
            if(!st.isEmpty()){
                while(!st.isEmpty() && h < heights[st.peek()]){
                    prevSmaller[st.pop()] = i;
                }
            }
            st.push(i);
        }

        int res= 0 ;
        for(int i=0; i<len; i++){
            
            int left = prevSmaller[i]+1;
            int right = nextSmaller[i]-1;

            res = Math.max(res, (right-left+1)* heights[i]);
        }

        return res;

        
    }
}