// https://leetcode.com/problems/implement-stack-using-queues

class MyStack {

    private Queue<Integer> queue = new LinkedList<>();
    int top=-1;
    public void push(int x) {
        queue.add(x);
        top=x;
    }

    public int pop() {
        for (int i=1; i<queue.size(); i++){
            int val = queue.remove();
            queue.add(val);  
            top = val;
        }

            
        return queue.remove();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}