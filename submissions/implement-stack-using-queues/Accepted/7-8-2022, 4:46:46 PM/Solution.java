// https://leetcode.com/problems/implement-stack-using-queues

class MyStack {

  Queue<Integer> que;
/** Initialize your data structure here. */
public MyStack() {
    que = new LinkedList<>();
}

/** Push element x onto stack. */
public void push(int x) {
    que.add(x);
    for(int i=0; i<que.size()-1; i++) {
        que.add(que.poll());
    }
}

/** Removes the element on top of the stack and returns that element. */
public int pop() {
    return que.remove();
    
}

/** Get the top element. */
public int top() {
    return que.peek();
    
}

/** Returns whether the stack is empty. */
public boolean empty() {
    return que.isEmpty();
    
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