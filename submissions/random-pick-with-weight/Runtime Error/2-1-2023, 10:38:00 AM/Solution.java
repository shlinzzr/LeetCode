// https://leetcode.com/problems/random-pick-with-weight

class Solution {
    int total;
    int[] w;
    List<Integer> list;
    // HashMap<Integer, Integer> map = new HashMap<>();
    
    TreeMap<Integer, Integer> map = new TreeMap<>();
    
    public Solution(int[] w) {
        
        this.w=w;
        int len = w.length;
        
        for(int i=1; i<len ;i++){
            w[i] += w[i-1];
            map.put(w[i], i);
        }
    }
    
    public int pickIndex() {
        
        Map.Entry<Integer, Integer> en  = map.ceilingEntry((int) (Math.random()*Double.valueOf(w[w.length-1])));
        
        return en.getValue();
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */