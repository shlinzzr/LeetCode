// https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream

class DataStream {

    int size;
    int val;
    Queue<Integer> q;
    boolean last;
    
    public DataStream(int value, int k) {
        q = new LinkedList<>();
        size = k;
        val = value;
        last=false;
            
    }
    
    public boolean consec(int num) {
        
        
        q.offer(num);
        if(q.size()>size)
            q.poll();
        
        if(q.size()<size){
            return false;
        }
            
        
        System.out.println();
        for(int i : q){
            if(i!=val){
                return false;
            }
                
        }

        return true;
        
        
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */