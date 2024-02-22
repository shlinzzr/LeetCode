// https://leetcode.com/problems/find-triangular-sum-of-an-array

class Solution {
    public int triangularSum(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        for(int n: nums)
            list.add(n);
        
        
        while(list.size()>1){
            
            List<Integer> tmp = new ArrayList<>();
            
            for(int i=0; i<list.size()-1; i++){
                
                int d = (list.get(i) + list.get(i+1))%10;
                
                tmp.add(d);
            }
            
            list = tmp;
        }
        
        return list.get(0);
        
    }
}