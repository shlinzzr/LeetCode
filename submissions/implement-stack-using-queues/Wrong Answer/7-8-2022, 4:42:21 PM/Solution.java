// https://leetcode.com/problems/implement-stack-using-queues

class MyStack {

    Queue queue;
    private int top;
    
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
        top=x;
    }
    
    public int pop() {
        queue.poll();
        return top;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */