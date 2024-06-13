// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();
        
        int[] prev = null;
        
        for(int[] curr : intervals){
            
            
            if(prev==null){
                prev=curr;
                continue;
            }
            System.out.println(prev[0] + "," + prev[1] + " " +curr[0] + ","+curr[1]);
            
            
            if(prev[1] >= curr[0]){
                prev[1]=Math.max(prev[1], curr[1]);
                
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(prev[0]);
                temp.add(prev[1]);
                
                list.add(temp);
                prev = curr;
            }
        }
        
        List<Integer> temp = new ArrayList<>();
        temp.add(prev[0]);
        temp.add(prev[1]);
        list.add(temp);
        
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            
            System.out.println(list.get(i).get(0) + " " + list.get(i).get(1));
            
            
          res[i][0] = list.get(i).get(0);  
            res[i][1] = list.get(i).get(1);  
        } 
        
        return res;
        
    }
}