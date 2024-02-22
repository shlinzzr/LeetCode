// https://leetcode.com/problems/employee-free-time

/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        
        List<Interval> list = new ArrayList<>();
        for(List<Interval> sch : schedule){
            for(Interval i1 : sch){
                list.add(i1);
            }
        }
        Collections.sort(list, (a, b) -> a.start==b.start ? a.end-b.end : a.start-b.start);
        
        // edge case
        if(list.size()==1)
            return res;
        
        
        Interval prev = list.get(0);
        for(int i=1; i<list.size(); i++){
            
            Interval curr = list.get(i);
            
            if(prev.end < curr.start){
                Interval val = new Interval(prev.end, curr.start);
                res.add(val);
                
            }else{
                curr.end = Math.max(prev.end, curr.end);
            }
            
            prev= curr;
        }
        
        
        
        return res;
        
        
        
    }
}