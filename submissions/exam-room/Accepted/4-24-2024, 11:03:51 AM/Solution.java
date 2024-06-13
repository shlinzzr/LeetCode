// https://leetcode.com/problems/exam-room

class ExamRoom {

    TreeSet<Integer> set ;
    int n;

    public ExamRoom(int n) {
        set = new TreeSet<>();  
        this.n = n;
    }
    
    public int seat() {
        
        if(set.size() == 0) {
            set.add(0);
            return 0;
        }

        int last = -1, max = 0, index = 0;
        
        for(int i : set) {
            if (last == -1) {
                max = i;
                index = 0;

            } else {
                if( ( i-last) /2 > max) {
                    max = (i - last)/2;
                    index = last + max;
                }
            }

            last = i;
           
        }
        
        if(last != -1 && max < n-1-last) {
            index = n-1;
        }            
        
        set.add(index);
        return index;
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