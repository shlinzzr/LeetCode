// https://leetcode.com/problems/random-pick-with-weight

class Solution {
    
    List<Integer> list;
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public Solution(int[] w) {
        int cnt=0;
        list = new ArrayList<>();
        for(int j=0; j<w.length; j++){
            int ww = w[j];
            for(int i=0; i<ww; i++){
                list.add(ww);
                map.put(list.size()-1, j);
            }
        }
    }
    
    public int pickIndex() {
        
        int idx = (int ) (Math.random() * Double.valueOf(list.size()));
        
        return map.get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */