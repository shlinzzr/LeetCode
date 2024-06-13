// https://leetcode.com/problems/moving-average-from-data-stream

class MovingAverage {


    List<Integer> list = new ArrayList<>();
    long sum=0;
    int size=0;
    public MovingAverage(int size) {
        this.size=size;
    }
    
    public double next(int val) {
        sum+=val;
        list.add(val);
        if(list.size()>size){
            sum-=list.get(0);
            list.remove(0);
        }

        return Double.valueOf(sum)/Double.valueOf(list.size());
            
        

    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */