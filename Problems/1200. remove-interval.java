// https://leetcode.com/problems/remove-interval

class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();

        int len = intervals.length;

        Arrays.sort(intervals, (a,b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);

       

        for(int i=0; i<len; i++){

            int[] cur = intervals[i];
            
            if(cur[1]<=toBeRemoved[0]){
                List<Integer> list = new ArrayList<>();
                list.add(cur[0]);
                list.add(cur[1]);
                res.add(list);
                continue;


            }else if( cur[0]<toBeRemoved[0] && cur[1]>toBeRemoved[0] && cur[1]<=toBeRemoved[1] ){
                cur[1] = Math.min(cur[1], toBeRemoved[0]);

                List<Integer> list = new ArrayList<>();
                list.add(cur[0]);
                list.add(cur[1]);
                res.add(list);

            }else if( cur[0]<toBeRemoved[0] && cur[1]>toBeRemoved[1]){
                List<Integer> list = new ArrayList<>();
                list.add(cur[0]);
                list.add(toBeRemoved[0]);
                res.add(list);

                list = new ArrayList<>();
                list.add(toBeRemoved[1]);
                list.add(cur[1]);
                res.add(list);

            }else if(cur[0]>=toBeRemoved[0] && cur[1]<=toBeRemoved[1]){
                continue;

            }else if(cur[0]>=toBeRemoved[0] && cur[0]<toBeRemoved[1]){
                cur[0] = Math.max(cur[0], toBeRemoved[1]);
                List<Integer> list = new ArrayList<>();
                list.add(cur[0]);
                list.add(cur[1]);
                res.add(list);

            }else if(cur[0] >= toBeRemoved[0]){ 
                List<Integer> list = new ArrayList<>();
                list.add(cur[0]);
                list.add(cur[1]);
                res.add(list);
            }
        }

        return res;




    }
}