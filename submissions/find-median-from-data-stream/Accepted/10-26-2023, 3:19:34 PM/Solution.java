// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap= new PriorityQueue<>( Collections.reverseOrder());
        minHeap= new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        if(maxHeap.size()>=minHeap.size()){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else{
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {

        if(minHeap.isEmpty())
            return (double)0;

        if((maxHeap.size()+minHeap.size())%2==0){
            return (Double.valueOf(maxHeap.peek())+Double.valueOf(minHeap.peek()))/2;
        }else{
            return Double.valueOf(minHeap.peek());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */