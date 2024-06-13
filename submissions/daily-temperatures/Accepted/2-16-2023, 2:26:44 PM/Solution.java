// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int len = temp.length;
        
        int[] res= new int[len];
        
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len; i++){
            while(!st.isEmpty() && temp[i]>temp[st.peek()]){
                res[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i);
        }
        
        return res;
    }
}