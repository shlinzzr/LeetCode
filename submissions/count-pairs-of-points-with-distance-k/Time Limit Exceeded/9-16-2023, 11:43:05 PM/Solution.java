// https://leetcode.com/problems/count-pairs-of-points-with-distance-k

class Solution {
    public int countPairs(List<List<Integer>> coord, int k) {
        int len = coord.size();
        
        int cnt = 0;
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                
                int x1 = coord.get(i).get(0);
                int y1 = coord.get(i).get(1);
                
                int x2 = coord.get(j).get(0);
                int y2 = coord.get(j).get(1);
                
                int distance = (x1 ^ x2) + (y1 ^ y2);
                if(distance ==k)
                    cnt++;
                
            }
        }
        
        return cnt;
    }
}