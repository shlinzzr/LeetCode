// https://leetcode.com/problems/lfu-cache

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class LFUCache {
    
    class Node{
        
        Node next;
        Node prev;
        int key;
        int val;
        
        public Node(){}
        public Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    
    Node head;
    Node tail;
    HashMap<Integer, Node> nmap; //key, node
    int capacity;
    
    HashMap<Integer, Integer> fmap;// key freq;
    TreeMap<Integer, List<Integer>> tmap// freq, List<key>

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
        
        
        int freq = fmap.get(key);
        List<Integer> list = tmap.get(freq);
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            int idx = iter.next;
            if(idx==key){
                iter.remove();
                break;
            }
        }
        
        list = tmap.getOrDefautl(freq+1, new ArrayList<>());
        list.add(key);
        tmap.put(freq+1, list);
        
        fmap.put(key, fmap.get(key)+1);
        
        
        
        
        return node.val;
    }
    
    
    private void add(Node node){
        
        Node next = head.next;
        node.next = next;
        next.prev = node;
        node.prev = head;
        head.next = node;
        nmap.put(node.key, node);
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
        
        fmap.put(key, fmap.getOrDefault(key, 0)+1);
        
        if(nmap.containsKey(key)){
            remove(nmap.get(key));
        }
        
        
        
        
        Node node = new Node(key, value);
        add(node);
        
        if(nmap.size()>capacity){
            remove(tail.prev);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */