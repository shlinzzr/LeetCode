// https://leetcode.com/problems/range-sum-of-sorted-subarray-sums

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int len = nums.length;
        List<Integer> list =new ArrayList<>();
        
        for(int st = 0; st<len; st++){
            for(int ed = st; ed<len; ed++){
                
                int sum =0;
                for(int i=st; i<=ed; i++){
                    sum+= nums[i];
                    
                }
                list.add(sum);
            }
        }
        
        Collections.sort(list);
        
        // System.out.println(list.toString());
        
        
        int M = (int) 1e9+7;
        
        long res =0 ;
        for(int i=left; i<=right; i++){
            res = (res + list.get(i-1))%M;
        }
        
        return (int)res;
    }
}