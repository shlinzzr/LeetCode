// https://leetcode.com/problems/design-circular-deque

class MyCircularDeque {

    class Node {
        
        Node next;
        Node prev;
        int val;
        public Node(){};
        public Node(int val){
            this.val = val;
        }
        
    }
    
    Node head;
    Node tail;
    int capacity;
    int size;
    
    
    public MyCircularDeque(int k) {
        head = new Node();
        tail = new Node();
        
        head.next = tail;
        head.prev = tail;
        tail.next = head;
        tail.prev = head;
        capacity=k;
        size=0;
    }
    
    public boolean insertFront(int value) {
        if(size==capacity)
            return false;
        
        Node next = head.next;
        Node prev = head.prev;
        
        Node node = new Node(value);
        node.next = next;
        node.prev = head;
        
        head.next = node;
        next.prev = node;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size==capacity)
            return false;
        
        Node next = tail.next;
        Node prev = tail.prev;
        
        Node node = new Node(value);
        node.next = next;
        node.prev = tail;
        
        tail.next = node;
        next.prev = node;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size==0)
            return false;
        
        Node next = head.next;
        Node prev = head.prev;
        
        next.prev = prev;
        prev.next = next;
        
        head = next;
        size--;
        
        return true;
        
        
    }
    
    public boolean deleteLast() {
        if(size==0)
            return false;
        
        Node next = tail.next;
        Node prev = tail.prev;
        
        next.prev = prev;
        prev.next = next;
        
        tail = prev;
        size--;
         return true;
        
    }
    
    public int getFront() {
        return head.next.val;
    }
    
    public int getRear() {
        return tail.next.val;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */