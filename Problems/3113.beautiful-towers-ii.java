// https://leetcode.com/problems/beautiful-towers-ii

class Solution {
    public long maximumSumOfHeights(List<Integer> H) {
        int len = H.size();

        long[] left = new long[len];
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        
        
        long res = 0, cur = 0;
        for (int i = 0; i < len; i++) {
            while (st.size() > 1 && H.get(i) < H.get(st.peek())) {
                int p1 = st.pop();
                int p2 = st.peek();
                cur -= 1L * (p1-p2)* H.get(p1);
            }
            cur += 1L * (i - st.peek()) * H.get(i);
            st.push(i);
            left[i] = cur;
        }

        st.clear();
        
        long[] right = new long[len];
        st.push(len);
        cur = 0;
        for (int i = len-1; i>=0; i--) {
            while (st.size() > 1 && H.get(i) < H.get(st.peek())) {
                int p1 = st.pop();
                int p2 = st.peek();
                cur -= 1L * (p2-p1) * H.get(p1);
            }
            cur += 1L * (st.peek()-i) * H.get(i);
            st.push(i);
            
            right[i] = cur;
            // res = Math.max(res, left[i] + cur - H.get(i));
        }
        
        for(int i=0; i<len; i++){
            res = Math.max(res, left[i]+right[i]-H.get(i));
        }

        return res;
    }
    
}