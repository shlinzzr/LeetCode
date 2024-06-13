// https://leetcode.com/problems/buildings-with-an-ocean-view

class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        Stack<int[]> st= new Stack<>();
        
        
        for(int i=0; i<n; i++){
            int h = heights[i];
            
            while(!st.isEmpty()&&st.peek()[0]<=h)
                st.pop();
            
            st.push(new int[]{h,i});
        }
        
        int[] res = new int[st.size()];
        
        for(int i=st.size()-1; i>=0; i--){
            res[i] = st.pop()[1];
        }
        
        return res;
    }
}