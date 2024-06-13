// https://leetcode.com/problems/my-calendar-ii

class MyCalendarTwo {

    TreeMap<Integer, Integer> map;
    
    public MyCalendarTwo() {
        map  = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        
        boolean a = map.floorKey(start)==null ? true : map.get(map.floorKey(start))<=start;
      
        boolean b = map.lowerKey(end) == null ? true : map.get(map.lowerKey(end))<start;
        boolean c = map.ceilingKey(start) == null ? true : map.ceilingKey(start) >=end;
        
        
        if(a && b && c) return true;
        return false;
    }   
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */