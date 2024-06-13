// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    boolean isEven=true;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); 
    }
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        
        if(isEven){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else{
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
            
        }
        isEven = !isEven;
    }

    // Returns the median of current data stream
    public double findMedian() {
//         System.out.println("findMedian");
//         for(int n : maxHeap){
//             System.out.print(n+",");
//         }
//         System.out.println();
        
//         for(int n : minHeap){
//             System.out.print(n+",");
//         } 
//         System.out.println();
        
        
        if(minHeap.size() == maxHeap.size()) {
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        } else if(minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
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