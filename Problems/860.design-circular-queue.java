// https://leetcode.com/problems/design-circular-queue

class MyCircularQueue {

    int[] arr;
    int head;
    int tail;
    int capacity;
    int size;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size =0 ;
        this.head = 0;
        this.tail=0;
        this.arr = new int[capacity];
    }
    
    public boolean enQueue(int value) {

        if(isFull()) return false;

        size++;
        arr[tail] = value;  
        tail = (tail+1) % capacity;

        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        size--;
        int res = arr[head];
        head = (head+1) % capacity;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return arr[head];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;

        return arr[(tail-1+capacity)%capacity];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */