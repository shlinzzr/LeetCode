// https://leetcode.com/problems/count-days-without-meetings

class Solution {
    public int countDays(int days, int[][] meetings) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int[] m : meetings){
            map.put(m[0], map.getOrDefault(m[0],0)+1);
            map.put(m[1]+1, map.getOrDefault(m[1]+1,0)-1);
        }
        map.put(days+1, map.getOrDefault(days+1,0)+1);

        int curr = 1 ; // start from day 1
        int res = 0;
        int agg = 0 ;
        for(int k : map.keySet()){
            
            int v = map.get(k);

            if(agg==0 && agg+v>0){
                res += k-curr;
            }else if(agg>0 && agg+v==0){
                curr = k;
            }
            agg += v;
        }

        return res;


        
    }
}