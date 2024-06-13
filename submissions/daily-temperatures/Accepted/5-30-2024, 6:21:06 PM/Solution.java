// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] t) {

        int len = t.length;

        int[] res = new int[len];

        Stack<Integer> st = new Stack<Integer>();

        for(int i=0; i<len; i++){
            int v = t[i];

            while(!st.isEmpty() && t[st.peek()] < v){
                int idx = st.pop();
                res[idx] = i-idx;
            }
            st.push(i);
        }

        return res;
        
    }
}