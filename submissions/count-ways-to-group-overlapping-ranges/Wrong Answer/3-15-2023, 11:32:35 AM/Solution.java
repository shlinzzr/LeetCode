// https://leetcode.com/problems/count-ways-to-group-overlapping-ranges

class Solution {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a,b)->a[0]==b[0] ? a[0]-b[0] : a[1]-b[1]);
        
        List<int[]> list = new ArrayList<>();
        
        int[] curr = ranges[0];
        int i=1;
        
        while(i<ranges.length){
            if(curr[1]<ranges[i][0]){
                while(curr[1]<ranges[i][0]){
                    curr[1]=ranges[i][1];
                    i++;
                }   
                i--;
            }else{
                curr=ranges[i];
                
            }
            

            list.add(curr);    
            i++;
        }
            
        
        int siz = list.size();
        return siz;
            
    }
}