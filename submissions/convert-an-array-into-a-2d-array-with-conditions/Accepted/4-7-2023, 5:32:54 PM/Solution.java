// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            
            int row = 0;
            if(res.size()<row+1)
            res.add(new ArrayList<>());
            
            int n = nums[i];
            
            while(res.get(row).contains(n)){
                row++;
                
                if(res.size()<row+1)
                    res.add(new ArrayList<>());
            }
            res.get(row).add(n);
        }
        
        // List<List<Integer>> rt = new ArrayList<>();
        // for(Set<Integer>set : res){
        //     rt.add(new ArrayList<>(set));
        // }
        
        return res;
        
    }
}