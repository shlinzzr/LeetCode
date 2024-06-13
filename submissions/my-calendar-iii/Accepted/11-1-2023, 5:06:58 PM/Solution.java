// https://leetcode.com/problems/my-calendar-iii

class MyCalendarThree {

    TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>(); // st , ed
        
    }
    
    public int book(int st, int ed) {

        map.put(st, map.getOrDefault(st, 0)+1);
        map.put(ed, map.getOrDefault(ed, 0)-1);
        int max = 0, curr= 0;
        for(int v: map.values()){
            curr += v;
            max = Math.max(max, curr);
        }

        return max;
        
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */