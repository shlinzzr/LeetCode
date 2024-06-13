// https://leetcode.com/problems/lru-cache

class LRUCache {

    class Node{
        Integer key;
        Integer val;
        Node prev;
        Node next;

        public Node(Integer k, Integer v){
            key=k;
            val=v;
        }
        
    }
    
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity;
    
    public LRUCache(int capacity) {
        this.head = new Node(null,null);
        this.tail = new Node(null,null);
        this.head.next = tail;
        this.tail.prev = head;
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
//         Node cur = head;
//         while(cur!=null){
//             System.out.println(cur.key);
//         }
        
        
        
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        }
    }
    
    private void removeNode(Node node){
        
        map.remove(node.key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    
    private void addNode(Node node){
        Node prev = head;
        Node next = head.next;
        node.prev = head;
        node.next = next;
        head.next = node;
        next.prev = node; 
        map.put(node.key, node);
        
        if(map.size()>capacity){
            removeNode(tail.prev);
        }
        
    }
    
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        
        if(!map.containsKey(key)){
            addNode(node);
        }else{
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