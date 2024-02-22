// https://leetcode.com/problems/min-stack

class MinStack {

    Stack<int[]> st;
    int min;
    public MinStack() {
        
        st = new Stack<>();
        min = Integer.MAX_VALUE;
        
    }
    
    public void push(int val) {
        
        
        st.push(new int[]{val, min});
        min = Math.min(min, val);
        
    }
    
    public void pop() {
        min = st.pop()[1];
        
    }
    
    public int top() {
        
        return st.peek()[0];
    }
    
    public int getMin() {
        return min;
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