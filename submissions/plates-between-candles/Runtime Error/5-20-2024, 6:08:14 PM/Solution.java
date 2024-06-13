// https://leetcode.com/problems/plates-between-candles

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] presum = new int[len];
        int[] nums = new int[len];
        int[] prev = new int[len];
        int[] next = new int[len];

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<len; i++){
            nums[i] = s.charAt(i)=='*' ? 1 : 0;
            presum[i] = i==0 ? nums[i] : nums[i] + presum[i-1];

            if(s.charAt(i)=='|'){
                // map.put(i, presum[i]);
                prev[i] = i;
            }else{
                prev[i]= i==0 ? -1 : prev[i-1];
            }
        }

        for(int i=len-1; i>=0; i--){
            if(s.charAt(i)=='|'){
                next[i] = i;
            }else{
                next[i] = i==len-1? len : next[i+1];
            }
        }

        int[] ans = new int[queries.length]; 
        for(int i=0; i<queries.length; i++){
            int[] q = queries[i];

            int hi = prev[q[1]];
            int lo = next[q[0]];
            if(hi==-1 || lo==len || hi<=lo) continue;
            ans[i] = presum[hi] - presum[lo-1];

            // Integer h = map.floorKey(q[1]);
            // Integer l = map.ceilingKey(q[0]);
            // if(h==null || l==null || h<l) continue;
            // ans[i] = map.get(h)-map.get(l);
        }

        return ans;


        
    }
}