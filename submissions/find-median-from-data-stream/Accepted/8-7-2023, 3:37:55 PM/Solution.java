// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {

    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    boolean odd;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>( (a,b)-> b-a);
        minHeap = new PriorityQueue<>();
        odd= false;
    }
    
    public void addNum(int num) {
        
        if(odd==false){
        // if(minHeap.size()<=maxHeap.size()){
            maxHeap.offer(num); // 0 
            minHeap.offer(maxHeap.poll()); // 1 
            
        }else{
            
            minHeap.offer(num);  // 1
            maxHeap.offer(minHeap.poll()); // 1
        }
        
        odd = !odd;
        
        
        
    }
    
    public double findMedian() {
        
        // if(minHeap.isEmpty() && maxHeap.isEmpty())
        //     return null;
        
        // System.out.println (odd + "  " + maxHeap.peek() + " " + minHeap.peek());
        
        
        // if(minHeap.size()!=maxHeap.size())
        if(odd==false)
             return (double) (maxHeap.peek()+ minHeap.peek())/2;
        else
             return minHeap.peek();
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */