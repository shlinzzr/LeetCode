// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        
        
        int[] prev = null;
        
        for(int[] curr : intervals){
            
            if(prev==null){
                prev=curr;
                continue;
            }
            
            if(prev[1]>=curr[0])
                prev[1] = curr[1];
            else{
                list.add(prev);
                prev=curr;
            }
        }
        
        list.add(prev);
        
        
        
        
        return list.toArray(new int[list.size()][]);
    }
}