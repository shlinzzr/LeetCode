// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
      
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<len; i++){
            
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int idx=st.pop();
                res[idx] = i-idx;
            }
            
            st.push(i);
            
        }
        
        
        return res;
    }
}