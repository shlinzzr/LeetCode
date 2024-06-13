// https://leetcode.com/problems/design-a-stack-with-increment-operation

class CustomStack {

    
    Node head;
    Node tail;
    int maxSize =0;    
    int len;
    
    class Node{
        
        Node next;
        Node prev;
        int val;
        
        public Node(int val){
            this.val=val;
        }
        
    }
    
    public CustomStack(int maxSize) {
        this.head = new Node(0);
        this.tail = new Node(0);
        this.head.next = tail;
        this.tail.prev = head;
        this.maxSize = maxSize;
        
    }
    
    public void push(int x) {
        if(this.len>=maxSize)
            return;
        
        Node n = new Node(x);
        Node prev = tail.prev;
        
        prev.next = n;
        n.next = tail;
        tail.prev = n;
        n.prev =prev;
        len++;
    }
    
    public int pop() {
        if(tail.prev==head)
            return -1;
        
        else{
            Node ele = tail.prev;
            Node prev = ele.prev;
            int val = ele.val;
            
            prev.next=tail;
            tail.prev=prev;
            len--;
            return val;
        }
    }
    
    public void increment(int k, int val) {
        Node cur = head.next;
        
        while(k>0&&cur!=tail){
            cur.val +=val;
            cur=cur.next;
            k--;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */