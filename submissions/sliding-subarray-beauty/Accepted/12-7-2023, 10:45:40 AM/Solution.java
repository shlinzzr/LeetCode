// https://leetcode.com/problems/sliding-subarray-beauty

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int len = nums.length;

        int[] res = new int[len-k+1];

        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int st =0;
        for(int ed=0; ed<len; ed++){
            map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
            if(ed<k-1) continue;

            res[st] = getXthValue(map, x);

        
            map.put(nums[st], map.getOrDefault(nums[st],0)-1);
            if(map.get(nums[st])<=0)
                map.remove(nums[st]);
            st++;


        }

        return res;

    }

    private int getXthValue(TreeMap<Integer, Integer> map, int x){

        int cnt = 0;
        for(int k : map.keySet()){
            if(k<0){
                cnt += map.get(k);
                if(cnt>=x)
                    return k;

            }else{
                return 0;
            }
        }

        return 0;
    }
}