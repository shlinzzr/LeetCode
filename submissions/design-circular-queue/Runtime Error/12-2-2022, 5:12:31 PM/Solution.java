// https://leetcode.com/problems/design-circular-queue

class MyCircularQueue {

    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
        public Node(){
        }
    }
    
    int front;
    int rear;
    Node head;
    Node tail;
    int capacity;
    int size;
    
    public MyCircularQueue(int k) {
        this.capacity = k;        
        this.size=0;
        this.front=0;
        this.rear=0;
    }
    
    public boolean enQueue(int value) {
        
        if(size<capacity){
            if(head==null){
                head = new Node(value);
                tail=head;
            }else{
                
                Node node = new Node(value);
                head.next = node;
                head = node;
            }
            
            size++;
            return true;
        }
        
        return false;
        
    }
    
    
    public boolean deQueue() {
        
        if(size==0)
            return false;
        
        Node next = tail.next;
        tail.next=null;
        tail = next;
        size--;
        
        return true;
    }
    
    public int Front() {
        return tail.val;
    }
    
    public int Rear() {
        return head.val;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */