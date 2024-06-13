// https://leetcode.com/problems/smallest-range-ii

class Solution {
    public int smallestRangeII(int[] nums, int k) {
        
        
        Arrays.sort(nums);
        
        if(nums.length==1)
            return 0;
        
        int len = nums.length;
        
        int min = nums[len-1] - nums[0];
        
        // Set<Integer> set = new TreeSet<>();
        
        
        for(int i=0; i<nums.length-1; i++){
            int a = nums[i];
            int b = nums[i+1];
            
            int high = Math.max(nums[len-1]-k, a+k);
            int low = Math.min(nums[0]+k, b-k);
            min = Math.min(min, high-low);
            
            
        }
        
        // List<Integer> list = new ArrayList<>(set);
        // for(int i=0; i<list.size()-1; i++){
        //     System.out.println(list.get(i));
        //     min = list.get(i+1) - list.get(i);
        // }
        
        
        return min;
        
        

    }
}