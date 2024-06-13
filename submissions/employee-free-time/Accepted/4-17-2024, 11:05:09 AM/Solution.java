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
    public List<Interval> employeeFreeTime(List<List<Interval>> sche) {

        List<Interval> res = new ArrayList<>();

        List<Interval> all = new ArrayList<>();
        for(List<Interval> sub : sche){
            all.addAll(sub);
        }

        Collections.sort(all, (a,b)-> a.start!=b.start ? a.start-b.start : a.end-b.end);


        Interval in = new Interval();
        for(int i=0; i<all.size(); i++){
            Interval cur = all.get(i);
            if(i==0){
                in.start = cur.end;
                continue;
            }
            
            if(cur.start<=in.start && cur.end>=in.start){
                in.start = Math.max(in.start, cur.end);

            }else if(cur.start>in.start){
                res.add(new Interval(in.start, cur.start));
                in.start = cur.end;
            }
        }

        return res;


        
    }
}