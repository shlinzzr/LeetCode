// https://leetcode.com/problems/number-of-distinct-averages

class Solution {
    public int distinctAverages(int[] nums) {
        int len = nums.length;
        
        Arrays.sort(nums);
        
        int st =0, ed=len-1;
        HashSet<Double> set = new HashSet<>();
        while(st<ed){
            
            double avg = (Double.valueOf(nums[st++]) +  Double.valueOf(nums[ed--]) )/2;
            set.add(avg);
        }
        
        return set.size();
    }
}