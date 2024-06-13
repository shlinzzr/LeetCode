// https://leetcode.com/problems/max-stack

class MaxStack {

     // TLE
    Stack<Integer> stack;
    Stack<Integer> stack2;
    int max;
    
    public MaxStack() {
        max = Integer.MIN_VALUE;
        stack = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        // Only push the old maximum value when the current 
        // maximum value changes after pushing the new value x.
        // "==" is included here so pop() implementation would be easier. 
        if (x >= max) {
            stack.push(max);
            max = x;
        }
        stack.push(x);
    }
    
    public int pop() {
        // if pop operation could result in the changing of the current maximum value, 
        // pop twice and change the current maximum value to the last maximum value.
        int ret = stack.pop();
        if (ret == max) {
            max = stack.pop();
        }
        return ret;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return max;
    }
    
    public int popMax() {
        int ret = max;
        int tmp = pop();
        // use stack2 to temporarily store the numbers before max appears.
        while (tmp != ret) {
            stack2.push(tmp);
            tmp = pop();
        }
        while (!stack2.isEmpty())
            push(stack2.pop());
        return ret;
    }
        
    }

// /**
//  * Your MaxStack object will be instantiated and called as such:
//  * MaxStack obj = new MaxStack();
//  * obj.push(x);
//  * int param_2 = obj.pop();
//  * int param_3 = obj.top();
//  * int param_4 = obj.peekMax();
//  * int param_5 = obj.popMax();
//  */

