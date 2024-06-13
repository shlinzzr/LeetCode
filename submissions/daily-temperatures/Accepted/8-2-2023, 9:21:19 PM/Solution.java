// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int len = temp.length;
        int[] ans = new int[len];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<len; i++){
            
            if(st.isEmpty())
                st.push(i);
            else{
                
                while(!st.isEmpty() && temp[st.peek()]<temp[i]){
                    int idx = st.pop();
                    ans[idx] = i-idx;
                }
                st.push(i);
            }
        }
        return ans;
    }
}