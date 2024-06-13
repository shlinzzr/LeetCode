// https://leetcode.com/problems/lru-cache

class LRUCache {

    class Node{

        int key;
        int val;
        Node next;
        Node prev;

        public Node(){}
        public Node(int key , int val){
            this.key=key;
            this.val=val;
        }

    }

    HashMap<Integer ,Node> map= new HashMap<>();

    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }   
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        remove(node);
        add(node);

        return node.val;
    }


    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

        map.remove(node.key);
    }

    
    private void add(Node node){

        //add 
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
        map.put(node.key, node);
    }


    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        
        Node node = new Node(key, value);
        add(node);

        if(map.size()>this.capacity){
            remove(tail.prev);
        }

        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */