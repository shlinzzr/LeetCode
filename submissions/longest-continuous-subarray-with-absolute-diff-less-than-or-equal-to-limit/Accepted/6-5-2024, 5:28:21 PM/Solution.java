// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        // 1. TreeMap : O(NlgN)
        int len = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>(); // val, cnt
        int max = 0;
        int st = 0;
        for(int ed=0; ed<len; ed++){

            map.put(nums[ed], map.getOrDefault(nums[ed],0)+1);

            while(map.lastKey()-map.firstKey()>limit){
                map.put(nums[st], map.get(nums[st])-1);
                if(map.get(nums[st])==0) map.remove(nums[st]);
                st++;
            }

            max = Math.max(max, ed-st+1);
        }

        return max==0 ? -1 : max;





        // //2. 找最大值跟最小值 直接想到mono stack (deque) O(N)
        // int len = nums.length;
        // Deque<Integer> dq_max = new ArrayDeque<>(); // idx => asc
        // Deque<Integer> dq_min = new ArrayDeque<>(); // idx
        // int st = 0, ed=0;

        // for(; ed<len; ed++){
        //     int n = nums[ed];

        //     while(!dq_max.isEmpty() && nums[dq_max.peekLast()]<n){
        //         dq_max.pollLast();
        //     }

        //     while(!dq_min.isEmpty() && nums[dq_min.peekLast()]>n){
        //         dq_min.pollLast();
        //     }
            
        //     dq_min.offer(ed);
        //     dq_max.offer(ed);

        //     //超過limit的話, 把min or max拉出來
        //     //看st 是在那一個 dq內
        //     if(nums[dq_max.peek()] - nums[dq_min.peek()]>limit){
        //         if(nums[st] == nums[dq_max.peek()]) dq_max.poll();
        //         if(nums[st] == nums[dq_min.peek()]) dq_min.poll();
        //         st++;
        //     }

        // }

        // return ed-st;



        

        // // //1. 找最大值跟最小值 : sliding window + treemap O(NlgN)
        // int len = nums.length;
        // TreeMap<Integer, Integer> map = new TreeMap<>(); // val, cnt
        // map.put(nums[0], 1);        
        // int max = 0;

        // int ed= 0;

        // for(int st=0; st<len; st++){
            
        //     while(map.lastKey() - map.firstKey()<=limit){
        //         max = Math.max(max, ed-st+1);
        //         ed++;
        //         if(ed<len) map.put(nums[ed], map.getOrDefault(nums[ed],0)+1);
        //         else break;
        //     }

        //     if(ed==len) break;

        //     map.put(nums[st], map.get(nums[st])-1);
        //     if(map.get(nums[st])==0) map.remove(nums[st]);
        // }

        // return max;



        
        // int st = 0, ed;
        // for (ed = 0; ed < len; ed++) {
        //     map.put(nums[ed], 1 + map.getOrDefault(nums[ed], 0));

        //     if (map.lastKey() - map.firstKey() > limit) {
        //         map.put(nums[st], map.get(nums[st]) - 1);
        //         if (map.get(nums[st]) == 0)
        //             map.remove(nums[st]);
        //         st++;
        //     }
        // }
        // return ed-st;


        
    }
}