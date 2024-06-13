// https://leetcode.com/problems/random-pick-with-weight

class Solution {
    int total;
    
    TreeMap<Integer, Integer> map = new TreeMap<>();
    
    public Solution(int[] w) {
        
        int len = w.length;
        
        for(int i=0; i<len ;i++){
            total+=w[i];
            map.put(total, i);
        }
        
        // for(Map.Entry<Integer, Integer> en : map.entrySet()){
        //     System.out.println(en.getKey() + " " + en.getValue());
        // }
        
        
    }
    
    public int pickIndex() {
        int rand = (int) (Math.random()*Double.valueOf(total));
        // Integer key = map.ceilingKey(rand+1);  // ceilingKey 是找>=的key 但我們這邊要排除等於的狀況。要記得加1
        Integer key = map.higherKey(rand); // 是找比rand 大一筆 的key值
        Map.Entry<Integer, Integer> en  = map.ceilingEntry(key);
        
        return en.getValue();
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */