// https://leetcode.com/problems/insert-interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;

        Arrays.sort(intervals, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);

        List<int[]> list= new ArrayList<>();
        int idx= 0;

        while(idx<len){
            if(intervals[idx][1] < newInterval[0]){
                list.add(intervals[idx]);
                idx++;
            }else{
                break;
            }
        }

        while(idx<len && intervals[idx][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }


        list.add(newInterval);

        while(idx<len){
            list.add(intervals[idx++]);

        }

        int[][] res = new int[list.size()][];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;


    }
}