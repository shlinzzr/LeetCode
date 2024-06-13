// https://leetcode.com/problems/make-array-non-decreasing-or-non-increasing

class Solution {
    public int convertArray(int[] nums) {
        int len = nums.length;

        Deque<Integer> asc = new ArrayDeque<>();
        Deque<Integer> desc = new ArrayDeque<>();

        int res1=0, res2=0;

        for(int i=0; i<len; i++){
            if(!asc.isEmpty() && nums[i]<=nums[asc.peekLast()]){
                res1 += nums[asc.peekLast()] - nums[i];
                asc.pollLast();
                asc.offer(i);
            }
            asc.push(i);


            if(!desc.isEmpty() && nums[i]>=nums[desc.peekLast()]){
                res2 += nums[i] - nums[desc.peekLast()];
                desc.pollLast();
                desc.offer(i);
            }
            desc.add(i);
        }

        // if(asc.size()==len || desc.size()==len){
        //     return 0;
        // }

        return Math.min(res1, res2);



    }
}