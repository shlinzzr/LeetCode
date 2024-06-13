// https://leetcode.com/problems/my-calendar-i

class MyCalendar {

    TreeMap<Integer, Integer> map ; // st, ed
    
    public MyCalendar() {
        map = new TreeMap<>();
        
    }
    
    public boolean book(int start, int end) {
        
        Integer floor = map.floorKey(start);
        Integer ceiling = map.ceilingKey(start);
        
        
        if( (floor==null || map.get(floor)<=start) && (ceiling==null || ceiling>=end) ){
            map.put(start, end);
            return true;
        }
            
        
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */