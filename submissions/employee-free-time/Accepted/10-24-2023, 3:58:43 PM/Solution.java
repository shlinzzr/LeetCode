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


        // // use pq to sort intervals and put into list
        // PriorityQueue<Interval> pq = new PriorityQueue<>(
        //     (a, b) -> a.start==b.start ? a.end-b.end : a.start-b.start
        // );
        for(List<Interval> sch : schedule){
            for(Interval i1 : sch){
                // pq.add(i1);
                list.add(i1);
            }
        }
        // List<Interval> list = new ArrayList<>();
        // while(!pq.isEmpty())
        //     list.add(pq.poll());
        
        Collections.sort(list, (a, b) -> a.start==b.start ? a.end-b.end : a.start-b.start);
        
        // edge case
        if(list.size()==1)
            return res;
        
        
        Interval prev = list.get(0);
        for(int i=1; i<list.size(); i++){
            
            Interval curr = list.get(i);
            
            if(prev.end < curr.start){
                prev.start = prev.end;
                prev.end = curr.start;
                res .add(prev);
                
            }else{
                curr.end = Math.max(prev.end, curr.end);
            }
            
            prev= curr;
        }
        
        
        
        return res;
        
        
        
    }
}