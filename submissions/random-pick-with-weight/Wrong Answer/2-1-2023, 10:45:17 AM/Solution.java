// https://leetcode.com/problems/random-pick-with-weight

class Solution {
    int total;
    int[] arr;
    
    TreeMap<Integer, Integer> map = new TreeMap<>();
    
    public Solution(int[] w) {
        
        this.arr=w;
        int len = w.length;
        map.put(0, 0);
        for(int i=1; i<len ;i++){
            arr[i] += arr[i-1];
            map.put(arr[i], i);
        }
        total=arr[len-1];
    }
    
    public int pickIndex() {
        int rand = (int) (Math.random()*Double.valueOf(total));
        Integer key = map.ceilingKey(rand);
        
        Map.Entry<Integer, Integer> en  = map.floorEntry((int) (Math.random()*Double.valueOf(total)));
        
        return en.getValue();
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */