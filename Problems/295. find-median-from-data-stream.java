// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    boolean flag;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        
        if(minHeap.size()>=maxHeap.size()){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());    
        }else{
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        
    }
    
    public double findMedian() {
        
        if(minHeap.size()==maxHeap.size()){
            return (Double.valueOf(minHeap.peek())+ Double.valueOf(maxHeap.peek()))/2;
        }else{
            return maxHeap.peek();
        }
        
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */