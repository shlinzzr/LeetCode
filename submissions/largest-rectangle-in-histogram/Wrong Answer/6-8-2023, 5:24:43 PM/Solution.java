// https://leetcode.com/problems/largest-rectangle-in-histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        
        //max = (nextSmaller - prevSmaller)* heights[i];
        
        int len = heights.length;
        
        int[] nextSmaller = new int[len];
        int[] prevSmaller = new int[len];
        Arrays.fill(nextSmaller, len-1);
        
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len; i++){
            int h = heights[i];
            while(!st.isEmpty() && heights[st.peek()]>h){
                nextSmaller[st.pop()] = i;
            }
            
            st.push(i);
        }
        
        
        st = new Stack<>();
        for(int i=len-1; i>=0; i--){
            int h = heights[i];
            while(!st.isEmpty() && heights[st.peek()]>h){
                prevSmaller[st.pop()]= i;
            }
            st.push(i);
        }
        
        int max = 0;
        for(int i=0; i<len; i++){
            max = Math.max(max, (nextSmaller[i]-prevSmaller[i]-1)*heights[i]);
        }
        
        return max;
        
        
        
            
    }
}