// https://leetcode.com/problems/buildings-with-an-ocean-view

class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> st = new Stack<>();
        
        int len = heights.length;
        
        for(int i=0; i<len; i++){
            
            while(!st.isEmpty() && heights[st.peek()]<= heights[i]){
                st.pop();
            }
            
            st.push(i);
        }
        
        
        int[] res = new int[st.size()];
        for(int i=st.size()-1; i>=0; i--){
            res[i] = st.pop();
        }
        
        return res;
    }
}