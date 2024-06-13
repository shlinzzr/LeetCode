// https://leetcode.com/problems/lfu-cache

class LFUCache {
    
    class Node {
        
        Node prev;
        Node next;
        int val;
        int key;
        
        public Node(){}
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        
    }
    
    
    HashMap<Integer, Integer> fmap;// key freq;
    int capacity;
    Node head;
    Node tail;
    HashMap<Integer, Node> nmap;
    


    public LFUCache(int capacity) {
        this.capacity = capacity;
        fmap = new HashMap<>();
        nmap = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {

        if(!nmap.containsKey(key))
            return -1;
        
        Node node = nmap.get(key);
        
        remove(nmap.get(key));
        add(node);
        
        return node.val;
    }
    
    private void add(Node node){
        
        Node next = head.next;
        node.next = next;
        next.prev = node;
        node.prev = head;
        head.next = node;
        nmap.put(node.key, node);
        
        if(nmap.size()>capacity){
            remove(tail.prev);
        }
        
    }
    
    private void remove(Node node){
        
        if(!nmap.containsKey(node.key))
            return;
        
        nmap.remove(node.key);
        
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }
    
    public void put(int key, int value) {
        
        Node node = new Node(key, value);
        
        if(!nmap.containsKey(key)){
            add(node);
        }else{
            remove(nmap.get(key));
            add(node);
        }
            
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */