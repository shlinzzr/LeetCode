// https://leetcode.com/problems/non-overlapping-intervals

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        // Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        Arrays.sort(intervals, new myComparator());
        
        for(int[] r : intervals){
            System.out.print("[" + r[0] + "," + r[1] + "], ");
        }
        System.out.println();
        
        int end = intervals[0][1];
        int cnt=1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                cnt++;
            }
        }
        
        
        return intervals.length - cnt;

    }
    
    class myComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return a[1]-b[1];
        }
    }
    
//      public int eraseOverlapIntervals(int[][] intervals) {
//         if (intervals.length == 0)  return 0;

//         Arrays.sort(intervals, new myComparator());
         
//         for(int[] r : intervals){
//             System.out.print("[" + r[0] + "," + r[1] + "], ");
//         }
//         System.out.println();
         
//         int end = intervals[0][1];
//         int count = 1;        

//         for (int i = 1; i < intervals.length; i++) {
//             if (intervals[i][0] >= end) {
//                 end = intervals[i][1];
//                 count++;
//             }
//         }
//         return intervals.length - count;
//     }
    
    
}