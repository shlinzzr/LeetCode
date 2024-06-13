// https://leetcode.com/problems/my-calendar-i

class MyCalendar {
    
   TreeMap<Integer, Integer> map;
    
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        
        Integer floorKey = map.floorKey(start);
        Integer ceilingKey = map.ceilingKey(start); // key point is here
        
        
        if((floorKey==null || map.get(floorKey)<=start) 
            && (ceilingKey==null ||ceilingKey>=end)){
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