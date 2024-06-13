// https://leetcode.com/problems/lru-cache

class LRUCache {

    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> map; // key, node
    
    
    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next=tail;
        tail.prev=head;
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        
        Node node = map.get(key);
        remove(node);
        add(node);
        
        
        return node.val;
    }
    
    private boolean add(Node node){
        
      
        
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
        
        // Node prev = tail.prev;
        // prev.next = node;
        // node.next = tail;
        // tail.prev= node;
        // node.prev= prev;
        
        map.put(node.key, node);
        
        return true;
        
    }
    
    
    private boolean remove(Node node ){
        
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        map.remove(node.key);
        return true;
    }
    
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(map.containsKey(key))
            remove(map.get(key));
        
        add(node);
        if(map.size()>capacity)
            remove(tail.prev);
    }
    
    
    class Node{
        
        Node next;
        Node prev;
        int val;
        int key;
        
        public Node(){}
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */