// https://leetcode.com/problems/count-the-number-of-good-partitions

class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int len = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            map.put(nums[i], i);
        }
        
        int m=0;
        int right =0;
        for(int i=0; i<len; i++){
            
            if(map.get(nums[i])==right){
                m++;
                right++;
            }
            
            right = Math.max(right, map.get(nums[i]));
        }
        
        return (int)quickPow(2, m-1);
       
    }
    
    private  long quickPow(long x, long n){   
        if (n == 0) {
            return 1;
        }
        
        int M = (int) 1e9+7;
        
        long y = quickPow(x, n / 2) % M;
        
        return n % 2 == 0 ? (y * y % M) : (y * y % M * x % M);
    }
}