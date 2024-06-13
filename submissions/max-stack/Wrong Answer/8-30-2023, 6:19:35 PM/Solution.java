// https://leetcode.com/problems/max-stack

class MaxStack {

    LinkedList<Node> list;
    Node head;
    HashMap<Integer, LinkedHashSet<Node>> map; // val, List<node>
    
    class Node{
        Integer val;
        Node next;
        Node prev;
        int max;
        public Node(Integer val, int max){
            this.val = val;
            this.max = max;
        }
    }
    
    
    
    public MaxStack() {
        map = new HashMap<>();
        head = new Node(null, Integer.MIN_VALUE);
    }
    
    public void push(int x) {
        
        Node node = new Node(x, Math.max(head.max, x));
        map.putIfAbsent(x, new LinkedHashSet<>());
        map.get(x).add(node);
        
        node.next = head;
        head.prev = node;
        head = node;
    }
    
    public int pop() {
        
        int val = head.val;
        map.get(val).remove(head);
        
        head = head.next;
        head.prev = null;
        return val;
    }
    
    public int top() {
        return head.val;
    }
    
    public int peekMax() {
        return head.max;
    }
    
    public int popMax() {
        int res = head.max;
        Node node = map.get(head.max).iterator().next();
        map.get(head.max).remove(node);
        
        
        if(node.val==head.val){
            head=head.next;
            if(head!=null)
                head.prev=null;
        }else{
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }
        
        return res;
        
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