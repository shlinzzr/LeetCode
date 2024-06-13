// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit

class Solution {
    public int longestSubarray(int[] A, int limit) {

        // Solution 2 : max-min Deque 
        // Time : O(n)
        // Space : O(n)

        Deque<Integer> qmax = new ArrayDeque<>();
        Deque<Integer> qmin = new ArrayDeque<>();
        qmax.add(0);
        qmin.add(0);

        int len = A.length;
        int res = 1;
        int ed=0;
        int max = A[0];
        int min = A[0];

        for (int st = 0; st < len && ed<len; ++st) {

            while(max-min <= limit){

                res = Math.max(res, ed-st+1);
                ed++;
                if(ed>=len) break;

                while(qmax.size()>0 && A[ed]>= A[qmax.peekLast()]) qmax.pollLast();
                qmax.add(ed);
                max = A[qmax.peek()];

                while(qmin.size()>0 && A[ed]<=A[qmin.peekLast()]) qmin.pollLast();
                qmin.add(ed);
                min = A[qmin.peek()];

            }

            if(ed>=len) break;

            // 此時max-min > limit
            // 要拿掉越界的 (應該只有一個越界 就是st本身)
            if(qmax.size()>0 && qmax.peek()<=st){
                qmax.poll();
                max = A[qmax.peek()];
            }

            if(qmin.size()>0 && qmin.peek()<=st){
                qmin.poll();
                min = A[qmin.peek()];
            }

        }
        return res;
    }
}




        /*// Solution 1 : TreeMap + 2 pointer
        // Time : O(nlgn)
        // Space : O(n)

        int len = nums.length;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[0], 1);

        int res = 0;

        int ed=0;
        for(int st=0; st<len; st++){
            while(map.lastKey()- map.firstKey()<=limit){
                res = Math.max(res, ed-st+1);
                ed++;

                if(ed<len)
                    map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
                else
                    break;
            }

            map.put(nums[st], map.get(nums[st])-1);
            if(map.get(nums[st])==0)
                map.remove(nums[st]);
        }

        return res;
    }
}
*/
//[8,2,4,7]