// https://leetcode.com/problems/lru-cache

class LRUCache {

    class Node{
        Node prev;
        Node next;
        int key;
        int val;
        public Node(int key, int val){
            this.key=key;
            this.val=val;
        }
        public Node(){}
    }
    
    int capacity;
    Map<Integer, Node> map;
    List<Integer> list;
    
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new ArrayList<>();
        
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key)) return -1;
        
        Node node = map.get(key);
        
        delete(node);
        add(node);
        
        return node.val;
        
    }
    
    private void delete(Node node){
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        node.prev = prev;
        map.remove(node.key);
    }
    
    private void add(Node node){
        Node next = head.next;
        node.next = next;
        next.prev = node;
        node.prev = head;
        head.next = node;
        map.put(node.key, node);
    }
    
        
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            delete(node);
            node.val = value;
            add(node);
            
        }else{
            
            if(map.size()==capacity){
                delete(tail.prev);
            }
            
            Node node = new Node(key, value);
            add(node);
            
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */