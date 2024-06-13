// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );
    }
    
    public void addNum(int num) {
        
        if(minHeap.size()<= maxHeap.size()){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());    
        }else{
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        
        
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        } else {
            return minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */