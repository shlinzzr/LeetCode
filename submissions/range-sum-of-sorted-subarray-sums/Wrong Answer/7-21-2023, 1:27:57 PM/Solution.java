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
        
        System.out.println(list.toString());
        
        int res =0 ;
        for(int i=left; i<=right; i++){
            res += list.get(i-1);
        }
        
        return res;
    }
}