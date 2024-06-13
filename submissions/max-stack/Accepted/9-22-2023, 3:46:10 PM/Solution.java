// https://leetcode.com/problems/max-stack

class MaxStack {
    
    private static class Node {
        public Node prev, next;
        public int value;
        
        public Node(int val) {
            this.value = val;
        }
    }
    
    private final Node head;
    private final TreeMap<Integer, LinkedList<Node>> map = new TreeMap<>(); 

    /** initialize your data structure here. */
    public MaxStack() {
        head = new Node(0);
        head.next = head.prev = head;
    }
    
    public void push(int x) {
        Node node = new Node(x);
        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
        
        map.putIfAbsent(x, new LinkedList<>());
        map.get(x).add(node);
        // map.computeIfAbsent(x, k -> new LinkedList<>()).add(node);
    }
    
    public int pop() {
        Node tail = head.prev;
        if (tail == head) {
            return 0;   // no element exist
        }
        deleteNode(tail);
        // since it's pop(), we are always sure that the last element in the map's value list will be the tail
        map.get(tail.value).removeLast();
        if (map.get(tail.value).isEmpty()) {
            map.remove(tail.value);
        }
        return tail.value;
    }
    
    public int top() {
        return head.prev.value;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int max = peekMax();
        Node node = map.get(max).removeLast();
        deleteNode(node);
        if (map.get(max).isEmpty()) {
            map.remove(max);
        }
        return max;
    }
    
    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}