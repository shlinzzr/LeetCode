// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[len];

        for(int i=0; i<len; i++){
            int t= temperatures[i];
            while(!st.isEmpty() && t>temperatures[st.peek()]){
                int p = st.pop();
                res[p] = i-p;
            }
            st.push(i);
        }

        return res;

    }
}