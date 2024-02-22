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
        head = new Node(-1);
        tail = new Node(-1);
        
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
        next.prev = node;
        
        node.prev = head;
        head.next = node;
        
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size==capacity)
            return false;
        
        Node prev = tail.prev;
        
        Node node = new Node(value);
        node.next = tail;
        prev.next = node;
        tail.prev = node;
        node.prev = prev;
        
        size++;
        
        
        return true;
    }
    
    public boolean deleteFront() {
        if(size==0)
            return false;
        
        Node node = head.next;
        
        head.next = node.next;
        node.next.prev = head;
        
        size--;
        
        return true;
        
        
    }
    
    public boolean deleteLast() {
        if(size==0)
            return false;
       
        Node node = tail.prev;
        
        tail.prev= node.prev;
        node.prev.next = tail;
        size--;
         return true;
        
    }
    
    public int getFront() {
        return head.next.val;
    }
    
    public int getRear() {
         return tail.prev.val;
    }
    
    private void println(){
        System.out.println("println");
        Node curr = head.next;
        while(curr.val!=-1){
            System.out.println(curr.val);
            curr=curr.next;
        }
       
        
    }
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}


/*["MyCircularDeque",
"insertFront", 7
"insertLast", 0
"getFront", 
"insertLast"  3,
"getFront",
"insertFront",  9
"getRear",
"getFront",
"getFront",
"deleteLast",
"getRear"]
[[5],[7],[0],[],[3],[],[9],[],[],[],[],[]]

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