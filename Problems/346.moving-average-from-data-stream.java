// https://leetcode.com/problems/moving-average-from-data-stream

class MovingAverage {
    
    Queue<Double> q;
    int win;
    double sum ;

    public MovingAverage(int size) {
        
        q = new LinkedList<>();
        this.win = size;
        this.sum=0;
        
    }
    
    public double next(int val) {
        double d = Double.valueOf(val);
        sum+=d;
        
        q.offer(d);
        if(q.size()>win){
            sum-=q.poll();
        }
        
        return sum/Math.min(q.size(), win);
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */