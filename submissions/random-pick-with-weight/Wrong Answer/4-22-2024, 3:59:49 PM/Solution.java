// https://leetcode.com/problems/random-pick-with-weight

class Solution {


    TreeMap<Integer, Integer> map ;
     int presum;
    public Solution(int[] w) {
        map = new TreeMap<>();
        map.put(0, 0);
        
        presum = 0;
       
        for(int i=0; i<w.length; i++){
            int val = w[i];
            presum += val;

            map.put(presum, i);
        }
        
    }
    
    public int pickIndex() {
        

        int idx = (int)(Math.random()*presum);
        System.out.println(presum + " " + idx);
        return map.floorKey(idx);
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */