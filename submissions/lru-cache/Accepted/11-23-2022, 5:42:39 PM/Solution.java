// https://leetcode.com/problems/lru-cache

class LRUCache {

    class Node{
        
        Node prev;
        Node next;
        Integer key;
        Integer val;
        
        public Node(Integer key, Integer val){
            this.key=key;
            this.val=val;
        }
        
    }
    
    Node head;
    Node tail;
    int capacity ;
    HashMap<Integer, Node> map;
    
    
    public LRUCache(int capacity) {
        
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        this.head.next = tail;
        this.tail.prev = head;
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        
        Node node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }

    private void removeNode(Node node){
        
        map.remove(node.key);
        
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        
    }
    
    private void addNode(Node node){
        Node next = head.next;
        
        node.prev = head;
        node.next = next;
        head.next = node;
        next.prev= node;
        
        map.put(node.key, node);
        
        if(map.size()>capacity){
            // Node prev = tail.prev;
            // map.remove(prev.key);
            // prev.next=null;
            removeNode(tail.prev);
        }
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(!map.containsKey(key))
            addNode(node);
        else{
            removeNode(map.get(key));
            addNode(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */