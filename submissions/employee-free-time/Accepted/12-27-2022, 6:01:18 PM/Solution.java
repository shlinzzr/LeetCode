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
        
        PriorityQueue<Interval> pq = new PriorityQueue<>(
            (i1, i2) -> i1.start==i2.start ? i1.end-i2.end : i1.start-i2.start
        );
        
        for(List<Interval> list : schedule){
            for(Interval i1 : list){
                pq.add(i1);
            }
        }
        List<Interval> list = new ArrayList<>();
        while(!pq.isEmpty())
            list.add(pq.poll());
        
        
        if(list.size()==1)
            return res;
        
        
        Interval curr = list.get(0);
        for(int i=1; i<list.size(); i++){
            
            Interval next = list.get(i);
            
            if(curr.end<next.start){
                curr.start = curr.end;
                curr.end = next.start;
                res.add(curr);
            }else{
                next.end = Math.max(curr.end, next.end);
            }
            curr=next;
        }
        
        return res;
        /*
        [[[7,24],[29,33],[45,57],[66,69],[94,99]],
        [[6,24],[43,49],[56,59],[61,75],[80,81]],
        [[5,16],[18,26],[33,36],[39,57],[65,74]],
        [[9,16],[27,35],[40,55],[68,71],[78,81]],
        [[0,25],[29,31],[40,47],[57,87],[91,94]]]*/
        
        //[0,25], [5,16], [6,24],[7,24],[9,16]
        
        
        
    }
}