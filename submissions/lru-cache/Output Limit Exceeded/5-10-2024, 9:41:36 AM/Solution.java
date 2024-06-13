// https://leetcode.com/problems/lru-cache

class LRUCache {

    class Node{

        int key;
        int val;
        Node next;
        Node prev;

        public Node(){}

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.prev = tail;
        tail.next = head;

        map  = new HashMap<>();

    }
    
    public int get(int key) {

        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);

        Node prev = node.prev;
        Node next = node.next;
        if(prev!=null) prev.next = next;
        if(next!=null) next.prev = prev;

        // add from tail
        Node last = tail.next;
        last.prev = node;
        node.prev = tail;
        tail.next = node;
        node.next = last;

        return node.val;
        
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            get(key);

        }else{
            if(map.size()==capacity){
                Node first = head.prev;
                Node prev = first.prev;

                prev.next = head;
                head.prev = prev;
                map.remove(first.key);
            }

            Node node = new Node(key, value);
            map.put(key, node);
            get(key);
        }

        System.out.println(map);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */