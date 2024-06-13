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

        if(all.isEmpty()) return res;

        Interval prev = all.get(0);
        for(int i=1; i<all.size(); i++){
            Interval curr = all.get(i);

            if(prev.end<curr.start){
                Interval it = new Interval(prev.end, curr.start);
                res.add(it);
                prev = curr;
                continue;

            }else if(prev.end>= curr.start) {
                prev.end = Math.max(prev.end, curr.end);
            }
        }

        return res;


        
    }
}