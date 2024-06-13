// https://leetcode.com/problems/make-the-prefix-sum-non-negative

class Solution {
    public int makePrefSumNonNegative(int[] nums) {
        int len = nums.length;

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<len; i++){
            list.add(nums[i]);
        }
        int[] presum = new int[len];

        int res = 0;

        int idx= 0 ;
        for(int i=0; i<list.size(); i++){
            presum[idx] = i==0? list.get(i) : presum[idx-1]+ list.get(i);
            if(presum[idx]<0){
                res++;
                presum[idx] -= list.get(i);
                list.add(list.get(i));
            }else{
                idx++;
            }
        }

        return res;
    }
}