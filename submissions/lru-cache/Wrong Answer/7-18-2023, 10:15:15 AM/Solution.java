// https://leetcode.com/problems/lru-cache

class LRUCache {

    class Node{
        
        
        int key;
        int val;
        
        Node next;
        Node prev;
        
        
        public Node(){
        }
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        
    }
    
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity;
    
    
    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key))
            return -1;
        
        
        // remove
        
        
        Node node = map.get(key);
        remove(node, map);
        // Node prev = node.prev;
        // Node next = node.next;
        // prev.next = next;
        // next.prev = prev;
        
        // add
        add(node, map);
        // next = head.next;
        // head.next = node;
        // node.next = next;
        // node.prev = head;
        // next.prev = node;
        
        
        return node.val;
    }
    
    
    private void remove(Node node, HashMap<Integer, Node> map){
         // remove
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        
        map.remove(node.key);
    }
    
    
    private void add(Node node, HashMap<Integer, Node> map){
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
        
        map.put(node.key, node);
    }
    
    
    public void put(int key, int value) {
        
        Node node = new Node(key, value);
        
        if(map.containsKey(key)){
           node = map.get(key); 
           remove(node, map);
        }
        add(node, map);
        
        if(map.size()>capacity){
            remove(tail.prev, map);
        }        
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */