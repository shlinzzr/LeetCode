// https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make

class Solution {
    public int getMaximumConsecutive(int[] coins) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int c: coins){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        
        int len = coins.length;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int cur= 0 ;


        while( map.size()>0){


            List<Integer> list = new ArrayList<>(map.keySet());

            for(int c : list){
                for(int a : set){

                    if(!set.contains(a+c)){
                        set.add(a+c);
                        map.put(c, map.get(c)-1);
                        if(map.get(c)==0) map.remove(c);
                    }
                }
            }

            while(set.contains(cur+1)){
                cur++;
            }

        }
        return cur;
        
    }
}