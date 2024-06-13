// https://leetcode.com/problems/largest-rectangle-in-histogram

class Solution {
    public int largestRectangleArea(int[] H) {
        
        // heights[i] * (nextSmaller-prevSmaller-1)
        
        int len = H.length;
        
        Stack<Integer> st = new Stack<>();
        int[] nextSmaller = new int[len];
        Arrays.fill(nextSmaller, len);
        
        for(int i=0; i<len; i++){
            if(!st.isEmpty()){
                while(!st.isEmpty() && H[st.peek()]>H[i] ){
                    nextSmaller[st.peek()] = i;
                    st.pop();
                }
            }
            st.push(i);
        }
        
        int[] prevSmaller = new int[len];
        st = new Stack<>();
        Arrays.fill(prevSmaller, -1);
        for(int i=len-1; i>=0; i--){
            if(!st.isEmpty()){
                while(!st.isEmpty() && H[st.peek()]>H[i]){
                    prevSmaller[st.peek()] = i;
                    st.pop();
                }
            }
            st.push(i);
        }
        
        
        int max =0;
        for(int i=0; i<len; i++){
            max = Math.max(max, H[i] * (nextSmaller[i]-prevSmaller[i]-1));
        }
        
        return max;
        
        
    }
}