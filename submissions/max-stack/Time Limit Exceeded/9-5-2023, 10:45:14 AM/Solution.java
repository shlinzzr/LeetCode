// https://leetcode.com/problems/max-stack

// class MaxStack {

//     /* TLE
//     Stack<Integer> st;
//     Stack<Integer> maxStack;
    
    
//     public MaxStack() {
//         st = new Stack<>();
//         maxStack = new Stack<>();
//     }
    
//     public void push(int x) {
//         st.push(x);
//         int max = maxStack.isEmpty() ? x : Math.max(maxStack.peek(), x);
//         maxStack.push(max);
//     }
    
//     public int pop() {
        
//         maxStack.pop();
//         return st.pop();
//     }
    
//     public int top() {
//         return st.peek();
//     }
    
//     public int peekMax() {
//         return maxStack.peek();
//     }
    
//     public int popMax() {
        
//         Stack<Integer> temp = new Stack<>();
        
//         int max = peekMax();
        
//         while(st.peek()!=max){
//             temp.push(this.pop());
//         }
//         this.pop();
        
//         while(!temp.isEmpty()){
//             this.push(temp.pop());
//         }
        
//         return max;
//     }*/
    
// }

// /**
//  * Your MaxStack object will be instantiated and called as such:
//  * MaxStack obj = new MaxStack();
//  * obj.push(x);
//  * int param_2 = obj.pop();
//  * int param_3 = obj.top();
//  * int param_4 = obj.peekMax();
//  * int param_5 = obj.popMax();
//  */


class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        pushHelper(x);
    }
    
    public void pushHelper(int x) {
        int tempMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        if (x > tempMax) {
            tempMax = x;
        }
        stack.push(x);
        maxStack.push(tempMax);
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack<>();
        
        while (stack.peek() != max) {
            temp.push(stack.pop());
            maxStack.pop();
        }
        stack.pop();
        maxStack.pop();
        while (!temp.isEmpty()) {
            int x = temp.pop();
            pushHelper(x);
        }
        return max;
    }
}