// https://leetcode.com/problems/random-pick-with-weight

class Solution {
    
    List<Integer> list;
    
    
    public Solution(int[] w) {
        
        list = new ArrayList<>();
        for(int ww : w){
            for(int i=0; i<ww; i++){
                list.add(ww);
            }
        }
    }
    
    public int pickIndex() {
        
        int idx = (int ) (Math.random() * Double.valueOf(list.size()));
        
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */