// https://leetcode.com/problems/random-pick-with-weight

class Solution {

    TreeMap<Integer, Integer> map;
    int sum = 0;

    public Solution(int[] w) {

        map = new TreeMap<>(); // sum, idx;
        
        

        for(int i=0; i<w.length; i++){
            sum += w[i];
            map.put(sum, i); // sum其實是屬於i+1, 屆時需要用higherkey來找
            // i==0的範圍應該是[0~sum)
            // i+1的範圍是 [sum~presum[i+1])
        }

        
    }
    
    public int pickIndex() {

        int key = (int) (Math.random()* sum);
        // System.out.println(key);
        return map.higherEntry(key).getValue();
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */