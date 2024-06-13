// https://leetcode.com/problems/count-nice-pairs-in-an-array

class Solution {
    public int countNicePairs(int[] nums) {
        int len = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>(); // val, cnt
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            // map.put(n, rev(n));
            int rev = rev(n);

            // System.out.println(rev + " " + n);
            // n + rev(x) == x + rev(n);
            // n-rev(n) = x-rev(x);


            // 42 - 24  == 97-79
            // 18


            if(!map.containsKey(n-rev)){
                map.put(n-rev, 1);
            }else{
                res += map.get(n-rev);
                map.put(n-rev, map.get(n-rev)+1);
                
            }
        }

        return res;

    }

    private int rev(int n){

        int res = 0;

        while(n>0){
            res*=10;
            res+=n%10;
            n/=10;
            
        }

        return res;

    }
}