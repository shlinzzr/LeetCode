// https://leetcode.com/problems/my-calendar-iii

class MyCalendarThree {
    TreeMap<Integer, Integer> map;
    public MyCalendarThree() {

        map = new TreeMap<>();
        
    }
    
    public int book(int startTime, int endTime) {
        
        map.put(startTime, map.getOrDefault(startTime, 0)+1);
        map.put(endTime, map.getOrDefault(endTime, 0)-1);
        
        int cur = 0;
        int max = 0 ;

        for(int x : map.keySet()){
            cur += map.get(x);
            max = Math.max(cur, max);
        }

        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */