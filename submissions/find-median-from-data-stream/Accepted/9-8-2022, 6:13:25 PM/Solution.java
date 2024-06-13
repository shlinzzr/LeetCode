// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {

    PriorityQueue<Integer> small ;
    PriorityQueue<Integer> large ;
    boolean isEven = true;
    
    public MedianFinder() {
        small = new  PriorityQueue<>( Collections.reverseOrder());
        large = new  PriorityQueue<>();
        isEven=true;
    }
    
    public void addNum(int num) {
        if(isEven){
            small.offer(num);
            large.offer(small.poll());
        }else{
            large.offer(num);
            small.offer(large.poll());
        }
        
         isEven = !isEven;
    }
    
    public double findMedian() {
         
        if(isEven){
            return (small.peek()+large.peek())/2.0;
        }else{
            return large.peek();
        }
        
    }
    
     // pq is not support get by index ...
    
//     PriorityQueue<Integer> pq;
    
    
//     public MedianFinder() {
//         pq = new PriorityQueue<>();
//     }
    
//     public void addNum(int num) {
//         pq.offer(num);
//     }
    
//     public double findMedian() {
//         int size =pq.size();
//        // if(size==0)
//        //     return -1;
        
//         if(size%2==0){
//             return (pq.get(size/2) + pq.get(size/2-1)) /2;
//         }else{
//             return pq.get(size/2);
//         }
//     }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */