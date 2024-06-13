// https://leetcode.com/problems/intersection-of-multiple-arrays

class Solution {
    public List<Integer> intersection(int[][] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int f : nums[0])
            set.add(f);
        
        for(int[] arr: nums){
            
            TreeSet<Integer> temp = new TreeSet<>();
            
            for(int a: arr){
                
                if(set.contains(a))
                    temp.add(a);
            }
            
            set = new TreeSet<>(temp);
        }
            
        return new ArrayList<>(set);
        
    }
}