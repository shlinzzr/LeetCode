// https://leetcode.com/problems/number-of-flowers-in-full-bloom

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        for(int[] f: flowers){
            cntMap.put(f[0], cntMap.getOrDefault(f[0],0)+1);
            cntMap.put(f[1]+1, cntMap.getOrDefault(f[1]+1,0)-1);
        }


        TreeMap<Integer, Integer> aggMap = new TreeMap<>();
        int agg = 0;
        for(int x : cntMap.keySet()){
            agg += cntMap.get(x);
            aggMap.put(x, agg);
        }

        
        int len = people.length;
        int[] res = new int[len];
        for(int i=0; i<len; i++){
            int t = people[i];
            Integer x = aggMap.floorKey(t);
            if(x!=null){
                res[i] = aggMap.get(x);
            }else{
                res[i] = 0;
            }
        }

        return res;



        
    }
}