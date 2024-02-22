// https://leetcode.com/problems/design-linked-list

class MyLinkedList {

    int length;
    Node head;
    
    public MyLinkedList() {
        this.length=0;
        this.head=null;
    }
    
    public int get(int index) {
        if(index<0 || index>=this.length)
            return -1;
        
        else{
            int cnt=0;
            Node curr =head;
            while(cnt != index){
                curr= curr.next;
                cnt++;
            }
            
            return curr.val;
        }
            
    }
    
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        this.head = newHead;
        this.length++;
    }
    
    public void addAtTail(int val) {
        if(this.length == 0) {
            addAtHead(val);
            return;
        }
        Node tail = new Node(val);
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = tail;
        this.length++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index==this.length){
            addAtTail(val);
            return;
        }
        
        if(index==0){
            addAtHead(val);
            return;
        }
        if(index<0 || index> length)
            return ;
        
        int cnt=0;
        Node curr =head;
        while(cnt!=(index-1)){
            curr= curr.next;
            cnt++;
        }

        Node newNode = new Node(val);
        newNode.next = curr.next;
        curr.next = newNode;
        this.length++;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>= length)
            return;
            
        Node curr =head;
            
        if(index==0)
            head=curr.next;
        else{
            Node prev = null;
            int cnt=0;
            while(cnt!=index){
                prev = curr;
                curr= curr.next;
                cnt++;
            }
            prev.next = curr.next;
            
        }
        
        this.length--;
    }
    
    
    class Node{
        
        int val;
        int idx;
        Node next;
        
        public Node(int val){
            this.val=val;
        }
    }
    
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */