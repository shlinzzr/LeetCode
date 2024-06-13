// https://leetcode.com/problems/max-stack

class MaxStack {

    Stack<Integer> st;
    Stack<Integer> maxStack;
    
    
    public MaxStack() {
        st = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
        int max = maxStack.isEmpty() ? x : Math.max(maxStack.peek(), x);
        maxStack.push(max);
    }
    
    public int pop() {
        
        maxStack.pop();
        return st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        
        Stack<Integer> temp = new Stack<>();
        
        int max = maxStack.peek();
        
        while(st.peek()!=max){
            temp.push(st.pop());
        }
        st.pop();
        
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
        
        return max;
        
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */