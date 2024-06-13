// https://leetcode.com/problems/min-stack

class MinStack {

    Node head;
    
    public MinStack() {
        
    }
    
    public void push(int val) {
        
        if(head==null){
            head = new Node(val, null, val);
        }else{
            head = new Node(val, head, Math.min(val, head.min));
        }
        
    }
    
    public void pop() {
        head=head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    
    class Node{
        
        int val;
        int min;
        Node next;
            
        public Node(int val, Node next, int min){
            this.val=val;
            this.next = next;
            this.min = min;
            
        }
        
        
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