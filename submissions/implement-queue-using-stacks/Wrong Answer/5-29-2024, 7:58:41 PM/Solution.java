// https://leetcode.com/problems/implement-queue-using-stacks

class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        
        st1 = new Stack<>();
        st2 = new Stack<>();
        
    }
    
    public void push(int x) {

        st1.push(x);
        
    }
    
    public int pop() {

        if(empty()){
            return -1;
        }

        if(st2.isEmpty()) 
            peek();

        return st2.pop();
        
    }
    
    public int peek() {

        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        return st2.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */