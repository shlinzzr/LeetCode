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

        Map<Integer, Integer> map = new HashMap<>();
        for(List<Interval> list : schedule){
            for(Interval it : list){

                map.put(it.start, map.getOrDefault(it.start, 0) +1);
                map.put(it.end, map.getOrDefault(it.end, 0) -1);
            }
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        int prev = -1;
        int cur =0 ;
        for(int x : keys){

            if(cur==0 && prev!=-1){
                Interval it = new Interval(prev, x);
                res.add(it);
            }
            cur += map.get(x);
            prev = x;
        }

        return res;
        
        
    }
}