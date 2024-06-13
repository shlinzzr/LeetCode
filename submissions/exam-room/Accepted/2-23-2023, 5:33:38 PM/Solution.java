// https://leetcode.com/problems/exam-room

class ExamRoom {
    TreeSet<Integer> seats ;
    int capacity ;

    public ExamRoom(int n) {
        seats = new TreeSet<>();  
        capacity = n;
    }
    
    public int seat() {
        
        if(seats.size() == 0) {
            seats.add(0);
            return 0;
        }

        int last = -1, max = 0, index = 0;
        
        for(int i : seats) {
            if (last == -1) {
                max = i;
                index = 0;

            } else if( max < ( i - last) /2) {
                max = (i - last)/2;
                index = last + max;
            }

            last = i;
           
        }
        
        if(last != -1 && max < capacity-1 -last) {
            seats.add(capacity -1);
            index = capacity -1;
        }else {
            seats.add(index);
        }
        return index;
    }
    
    public void leave(int p) {
        
        seats.remove(p);
    }
}