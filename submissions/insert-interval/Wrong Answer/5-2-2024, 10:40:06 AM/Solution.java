// https://leetcode.com/problems/insert-interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;

        Arrays.sort(intervals, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);

        List<int[]> list= new ArrayList<>();
        int idx= 0;
        while(idx<len){
            int[] cur = intervals[idx];
            if(cur[1] <= newInterval[0]){
                list.add(cur);
                idx++;
            }else{
                break;
            }
        }

        System.out.println("list.size(0)=" + list.size());

        while(idx<len && intervals[idx][0]<=newInterval[1]){
            int[] cur = intervals[idx];
            newInterval[0] = Math.min(newInterval[0], cur[0]);
            newInterval[1] = Math.max(newInterval[1], cur[1]);
            idx++;
        }

         System.out.println("newInterval=" + newInterval[0] + "_"+ newInterval[1]);

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