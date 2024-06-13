// https://leetcode.com/problems/lru-cache

class LRUCache {

    
    class Node{
        
        Integer key;
        Integer val;
        Node next;
        Node prev;
        
        public Node(Integer key, Integer val){
            this.key=key;
            this.val=val;
        }
    }
    
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity;
    
    public LRUCache(int capacity) {
        
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next=tail;
        tail.prev=head;
        map=new HashMap<Integer, Node>();
        this.capacity=capacity;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        
        Node node = map.get(key);
        remove(node);
        add(node);
        
        return node.val;
    }
    
    private boolean remove(Node node){
        
        if(!map.containsKey(node.key)){
            return false;
        }
        
        map.remove(node.key);
        
        Node next = node.next;
        Node prev = node.prev;
        prev.next=next;
        next.prev=prev;
        
        return true;
    }
    
    private void add(Node node){
        Node next = head.next;
        node.next = next;
        next.prev=node;
        head.next=node;
        node.prev=head;
        map.put(node.key, node);
        
        if(map.size()>capacity){
            remove(tail.prev);
        }
    }
    
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(!map.containsKey(key)){
            add(node);
        }else{
            remove(map.get(key));
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