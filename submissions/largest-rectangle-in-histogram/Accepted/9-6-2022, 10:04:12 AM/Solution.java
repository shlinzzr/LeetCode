// https://leetcode.com/problems/largest-rectangle-in-histogram

class Solution {
    public int largestRectangleArea(int[] h) {
      int n = h.length, i = 0, max = 0;

      Stack<Integer> st = new Stack<>();

      while (i < n) {
        // as long as the current bar is shorter than the last one in the stack
        // we keep popping out the stack and calculate the area based on
        // the popped bar
        while (!st.isEmpty() && h[i] < h[st.peek()]) {
            // tricky part is how to handle the index of the left bound
            
            int pop = st.pop();
            // System.out.println(pop + " " + (st.isEmpty() ? 0:st.peek()));
            max = Math.max(max, h[pop] * (i - (st.isEmpty() ? 0 : st.peek() + 1)));
        }
        // put current bar's index to the stack
        st.push(i++);
      }

      // finally pop out any bar left in the stack and calculate the area based on it
      while (!st.isEmpty()) {
        max = Math.max(max, h[st.pop()] * (n - (st.isEmpty() ? 0 : st.peek() + 1)));
      }

      return max;
    }
}