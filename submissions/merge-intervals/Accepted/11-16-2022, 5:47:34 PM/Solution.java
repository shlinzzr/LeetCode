// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, 
            (i1,i2) -> i1[0]-i2[0]                    
                   );
        
        
        int[] curr = null;
        
        List<int[]> list = new ArrayList<>();
        for(int[] sec : intervals){
            
            if(curr==null){
                curr = sec;
                continue;
            }
            
            if(sec[0]<=curr[1]){
                curr[1] = Math.max(curr[1],sec[1]);
            }else{
                list.add(curr);
                curr = sec;
            }
        }
        
        list.add(curr);
        int[][] res = new int[list.size()][2];
        
        for(int i=0; i<list.size(); i++){
            res[i]=list.get(i);
        }
        
        return res;
        
    }
}