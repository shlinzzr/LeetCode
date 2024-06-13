// https://leetcode.com/problems/non-overlapping-intervals

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        // Arrays.sort(intervals, new myComparator());
        
        // for(int[] r : intervals){
        //     System.out.print("[" + r[0] + "," + r[1] + "], ");
        // }
        // System.out.println();

        int count=0;
        int[] prev = intervals[0];
        
        for(int i=1; i<intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0]<prev[1]){
                count++;
                prev[1] = Math.min(curr[1], prev[1]);
            }else{
                prev = curr;
            }
        }
        
        
        return count;

    }
    
    // class myComparator implements Comparator<int[]>{
    //     public int compare(int[] a, int[] b){
    //         return a[1]-b[1];
    //     }
    // }
    
}