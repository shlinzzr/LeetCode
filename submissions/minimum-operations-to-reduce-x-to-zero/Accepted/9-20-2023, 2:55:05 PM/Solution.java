// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero

class Solution {
    public int minOperations(int[] nums, int x) {
        
        //huifeng hashmap + prefix https://www.youtube.com/watch?v=RwmNMRdnLl0
        // presum[a] + sufsum[b] = x
        // => two sum

        int len = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);


        int presum = 0;
        for(int i=0;i<len;i++){
            presum += nums[i];
            int a = i+1;
            map.put(presum, a);
        }

        int min = Integer.MAX_VALUE;

        if(map.containsKey(x)){
            min = map.get(x);
        }

        int sufsum = 0;
        for(int i=len-1; i>=0; i--){
            sufsum += nums[i];
            int b = len-i;

            if(map.containsKey(x-sufsum)){
                int a = map.get(x-sufsum);
                if(a<i){ // overlap is not allow
                    min = Math.min(min, a+b);
                }
            }
        }

        return min==Integer.MAX_VALUE? -1 : min;



        
        
        
    }
}