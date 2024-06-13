// https://leetcode.com/problems/plates-between-candles

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] presum = new int[len];
        int[] nums = new int[len];

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<len; i++){
            nums[i] = s.charAt(i)=='*' ? 1 : 0;
            presum[i] = i==0 ? nums[i] : nums[i] + presum[i-1];

            if(s.charAt(i)=='|'){
                map.put(i, presum[i]);
            }
        }

        int[] ans = new int[queries.length]; 
        for(int i=0; i<queries.length; i++){
            int[] q = queries[i];
            Integer h = map.floorKey(q[1]);
            Integer l = map.ceilingKey(q[0]);
            if(h==null || l==null || h<l) continue;

            ans[i] = map.get(h)-map.get(l);
        }

        return ans;


        
    }
}