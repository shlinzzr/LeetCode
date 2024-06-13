// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int len = temp.length;
        
        int[] res = new int[len];
        Stack<Integer> st = new Stack<>();
        
        for(int i=len-1; i>=0; i--){
            
            while(!st.isEmpty() && temp[i]>temp[st.peek()]){
                int idx = st.pop();
                res[idx] = i-idx;
            }
            
            st.push(i);
        }
        
        return res;
        
    }
}
        
