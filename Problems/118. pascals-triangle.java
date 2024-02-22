// https://leetcode.com/problems/pascals-triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        
        /*
        1 
        1 1 
        1 2 1
        1 3 3 1
        1 4 6 4 1
        
        */
        for(int i=0; i<numRows; i++){
            
            res.add(new ArrayList<>());
            for(int j=0; j<i+1; j++){
                if(j==0 || j==i){
                    res.get(i).add(1);
                }else{
                    res.get(i).add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
                }
            }
        }
        
        return res;
        
    }
}