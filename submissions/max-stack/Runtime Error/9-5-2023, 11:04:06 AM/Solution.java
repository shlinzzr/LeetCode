// https://leetcode.com/problems/max-stack

class MaxStack {

    Node head;
    TreeMap<Integer, LinkedList<Node>> map; // val, List<node>
    
    class Node{
        Integer val;
        Node next;
        Node prev;
        public Node(Integer val){
            this.val = val;
        }
    }
    
    
    
    public MaxStack() {
        map = new TreeMap<>();
        head = new Node(null);
        head.next = head;
        head.prev = head;
    }
    
    public void push(int x) {
        
        Node node = new Node(x);
        node.next = head;
        head.prev = node;
        head = node;
        
        map.putIfAbsent(x, new LinkedList<Node>());
        map.get(x).add(node);
        
    }
    
    public int pop() {
        
        Node tail = head.prev;
        if(tail==head)
            return 0;
        
        deleteNode(tail);
        map.get(tail.val).removeLast();
        if(map.get(tail.val).isEmpty())
            map.remove(tail.val);
        
        return tail.val;
    }
    
    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int top() {
        return head.prev.val;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int max = this.peekMax();
        Node node = map.get(max).removeLast();
        return max;
    }
}


// 5 1 5
// top 5 
// popmax  :  5
// top


/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */