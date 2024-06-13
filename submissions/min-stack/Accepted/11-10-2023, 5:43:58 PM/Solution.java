// https://leetcode.com/problems/min-stack

class MinStack {

    Stack<long[]> st;
    long min;

    public MinStack() {
        st = new Stack<long[]>();
        min = Integer.MAX_VALUE;
        System.out.println(min);

    }
    
    public void push(int val) {

       st.push(new long[]{val, (int)min});
        min = Math.min(min, val);
     
    }
    
    public void pop() {
        long[] p = st.pop();
        min = (int)p[1];
    }
    
    public int top() {
        return (int)st.peek()[0];
        
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */