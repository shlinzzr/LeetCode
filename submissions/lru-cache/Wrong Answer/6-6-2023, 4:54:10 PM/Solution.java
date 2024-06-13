// https://leetcode.com/problems/lru-cache

class LRUCache {
    
    class Node{
        Node next;
        Node prev;
        int key;
        int val;
        
        public Node(){}
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> map;
        
    
    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key)){
            return -1;
        }
        
        Node node = map.get(key);
        
        remove(node);
        add(node);
        
        return node.val;
    }
    
    private void remove(Node node){
        map.remove(node.key);
        
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }
    
    private void add(Node node){
        
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
        
        map.put(node.key, node);
    }
    
    
    public void put(int key, int value) {
        
        Node node = null;
        if(map.containsKey(key)){
            node = map.get(key);
            remove(node);
        }else{
            node = new Node(key, value);
        }
        
        add(node);
        
        
        if(map.size()>capacity)
            remove(tail.prev);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */