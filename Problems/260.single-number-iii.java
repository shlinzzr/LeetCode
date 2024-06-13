// https://leetcode.com/problems/single-number-iii

class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums){
            if(set.contains(n)){
                set.remove(n);
            }else{
                set.add(n);
            }
        }
        
        List<Integer> list = new ArrayList<>(set);
        
        return new int[]{list.get(0), list.get(1)};
        
    }
}