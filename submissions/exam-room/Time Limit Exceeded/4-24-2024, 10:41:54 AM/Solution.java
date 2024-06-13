// https://leetcode.com/problems/exam-room

class ExamRoom {

    
    // -1   n == 2
    // -1, 0, ... n
    
    // n, size = 0; if(size==0) return 0
    // 0, n-1
    //TreeMap? [0, 2n] size=1;
    // [0,0], [1, n]
    
    //
    
    // TreeMap<Integer, Integer> map;
    int n;
    TreeSet<Integer> set;
    
    public ExamRoom(int n) {
        // map = new TreeMap<>();
        set = new TreeSet<>();
        this.n=n;
    }
    
    public int seat() {
        
        if(set.size()==0){
            set.add(0);
            return 0;
            
            
        }else{
            int max=0;
            int seat=0;
            
            for(int k : set){
                
                boolean leftNull = false;
                Integer left = set.lower(k);
                if(left==null){
                    leftNull = true;
                    left=0;  
                } 
                int dis = leftNull ? 2*(k-left) : k-left;
                dis = dis/2*2;
                if(dis>max){
                    max = dis;
                    seat = leftNull? left : left+dis/2;
                }
                
                boolean rightNull = false;
                Integer right = set.higher(k);
                if(right==null) {
                    right = n-1;   
                    rightNull=true;
                }
                dis = rightNull ? 2*(right-k) : right-k;
                dis = dis/2*2;
                if(dis>max){
                    max = dis;
                    seat = rightNull? right : k + dis/2;
                }
            }
            
            set.add(seat);
            return seat;
        }
        
    }
    
    public void leave(int p) {
        
        set.remove(p);
        
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */