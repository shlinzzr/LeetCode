// https://leetcode.com/problems/largest-rectangle-in-histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
        // height[i] * (nextSmaller-prevSmaller-1)
        
        int len = heights.length;
        
        int[] nextSmaller = new int[len];
        Arrays.fill(nextSmaller, len);
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len; i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }
        
//         for(int n : nextSmaller){
//             System.out.print(n + ", ");
//         }
//         System.out.println();
        
        
        int[] prevSmaller = new int[len];
        Arrays.fill(prevSmaller, -1);
        st = new Stack<>();
        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        
        int max = 0;
        for(int i=0; i<len; i++){
            int area = heights[i] * (nextSmaller[i] - prevSmaller[i]-1);
            max = Math.max(max, area);
        }
        
        return max;
        
    }
}