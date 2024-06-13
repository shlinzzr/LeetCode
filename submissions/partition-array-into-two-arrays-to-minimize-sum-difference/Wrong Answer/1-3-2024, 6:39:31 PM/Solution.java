// https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference

class Solution {
    public int minimumDifference(int[] nums) {
        int len = nums.length;
        int n = len/2;

        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        for(int i=0; i<n; i++)
            nums1.add(nums[i]);
        for(int i=n; i<2*n; i++)
            nums2.add(nums[i]);

        Map<Long, TreeSet<Long>> map2 = helper(nums2); //挑幾個數字, List<sum是多少>
        long sum = accmulate(nums);
        long ret = Long.MAX_VALUE;


        // 前面15個挑i個, 32767種排列組合 後面15個挑n-i=j個 
        for(int state=0; state<(1<<n); state++){
            long x = 0;
            int i = popcnt(state); //算挑幾個
            for(int k=0; k<n; k++){
                if( ((state>>k)&1) ==1 ){
                    x+=(long)nums1.get(k);
                }
            }

            long j=n-i;
            Long key = map2.get(j).floor(sum/2-x);
            if(key!=null){
                ret = Math.min(ret, Math.abs(key*x + 2*x-sum));
            }
            if(key!=null && key!=map2.get(j).first()){
                key = map2.get(j).lower(key);
                ret = Math.min(ret, Math.abs(key*2+2*x-sum));
            }
        }

        return (int)ret;
        
    }

    private int popcnt(int state){
        int cnt = 0;
        while(state>0){
            cnt += state&1;
            state>>=1;
        }
        return cnt;
    }

    private long accmulate(int[] nums){
        long sum = 0 ;
        for(int n : nums){
            sum += (long)n;
        }
        return sum;
    }

    private TreeMap<Long, TreeSet<Long>> helper(  List<Integer> nums){
        TreeMap<Long, TreeSet<Long>> map = new TreeMap<>();
        int n = nums.size();
        for(int state=0; state<(1<<n); state++){
            long sum = 0 ;
            int k = popcnt(state);
            for(int i=0; i<n; i++){
                if((((state>>i)&1) ==1))
                    sum += (long) nums.get(i);
            }

            map.putIfAbsent((long)k, new TreeSet<>());
            map.get((long)k).add(sum);
        }

        return map;

    }
}