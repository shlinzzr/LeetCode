// https://leetcode.com/problems/count-nice-pairs-in-an-array

class Solution {
    public int countNicePairs(int[] nums) {
        int len = nums.length;
        int M = (int) 1e9+7;
        HashMap<Long, Long> map = new HashMap<>(); // val, cnt
        long res = 0;
        for(int n : nums){
            // map.put(n, rev(n));
            long rev = rev(n);

            // System.out.println(rev + " " + n);
            // n + rev(x) == x + rev(n);
            // n-rev(n) = x-rev(x);


            // 42 - 24  == 97-79
            // 18


            if(!map.containsKey(n-rev)){
                map.put(n-rev, 1L);
            }else{
                res += map.get(n-rev);
                map.put(n-rev, map.get(n-rev)+1);
                
            }
        }

        return (int )(res%M);

    }

    private long rev(long n){

        int res = 0;

        while(n>0){
            res*=10;
            res+=n%10;
            n/=10;
            
        }

        return res;

    }
}