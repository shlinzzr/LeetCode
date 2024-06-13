// https://leetcode.com/problems/random-pick-with-weight

class Solution {

    TreeMap<Integer, Integer> map;
    int sum = 0;

    public Solution(int[] w) {

        map = new TreeMap<>(); // sum, idx;
        
        

        for(int i=0; i<w.length; i++){
            sum += w[i];
            map.put(sum, i);
        }

        
    }
    
    public int pickIndex() {

        int key = (int) (Math.random()* sum);
        // System.out.println(key);
        return map.ceilingEntry(key).getValue();
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */