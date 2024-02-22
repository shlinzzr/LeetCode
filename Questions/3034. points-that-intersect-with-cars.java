// https://leetcode.com/problems/points-that-intersect-with-cars

class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for(List<Integer> list : nums){
            
            for(int i=list.get(0) ; i<=list.get(1) ; i++){
                set.add(i);
            }
        } 
        
        int res = 0;
        for(int i=set.first(); i<=set.last(); i++){
            
            if(set.contains(i))
                res++;
        }
       
        return res;
        
    }
}