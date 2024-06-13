// https://leetcode.com/problems/count-the-number-of-fair-pairs

class Solution {
    
    // ref :https://leetcode.com/problems/count-the-number-of-fair-pairs/discuss/3178075/java-approach-tracing-simple-tc-o-n-log-n-sc-o-1
    
    /*
2 5
2 5
3 3
4 4
5 5
6 6
*/
    
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            long b = atMost(nums, i, upper-nums[i]) ;
            long a =  atLeast(nums, i, lower- nums[i]-1);
            
            if(b==a)
                continue;
            result +=  (b-a+1);
            
            System.out.println(a + " "  + b + " result="+result);
        }
        return result;
    }
    public long atMost(int[] nums, int index, int target) {
        int start = index + 1;
        int end = nums.length-1;
        while (start < end) {
            int mid = start + (end - start+1) / 2;
            
            while(mid+1<nums.length && nums[mid]==nums[mid+1])
                mid++;
            
            System.out.println("mid="+mid);
            
            if (nums[mid] > target){
                
                end = mid-1;
                
            } else {
                start = mid;;
            }
        }
        return start;
    }
     public long atLeast(int[] nums, int index, int target) {
        int start = index + 1;
        int end = nums.length-1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}