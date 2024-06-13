// https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream

class DataStream {

    int size;
    int val;
    Queue<Integer> q;
    int i = 0;
    
    public DataStream(int value, int k) {
        q = new LinkedList<>();
        size = k;
        val = value;
        i=0;
            
    }
    
    public boolean consec(int num) {
        
        if(num!=val){
            i=0;
            return false;
        }
        
        i++;
        
        return i>=size;
        
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */