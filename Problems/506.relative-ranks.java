// https://leetcode.com/problems/relative-ranks

class Solution {
    public String[] findRelativeRanks(int[] score) {

        int len = score.length;
        TreeMap<Integer, Integer> map = new TreeMap<>(); // score, idx

        for(int i=0; i<len ;i++){
            map.put(score[i], i);
        }
        String[] res = new String[len];

        int rank = len;
        for(int k : map.keySet()){
            String s = rank + "";
            if(rank==1){
                s = "Gold Medal";
            }else if(rank==2)
                s = "Silver Medal";
            else if(rank==3)
                s = "Bronze Medal";
            

            res[map.get(k)] = s;
            rank--;
        }

        return res;
        
    }
}