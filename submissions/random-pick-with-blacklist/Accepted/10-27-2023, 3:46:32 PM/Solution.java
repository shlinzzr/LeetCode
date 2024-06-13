// https://leetcode.com/problems/random-pick-with-blacklist

class Solution {
    
    // N: [0, N)
    // B: blacklist
    // B1: < N
    // B2: >= N
    // M: N - B1
    int len;
    Random r;
    Map<Integer, Integer> map;

    public Solution(int N, int[] blacklist) {
        map = new HashMap();
        for (int b : blacklist) // O(B)
            map.put(b, -1);
        len = N - map.size(); // M = 白名單的長度
        
        for (int b : blacklist) { // O(B)
            if (b < len) { // re-mapping
                while (map.containsKey(N - 1))
                    N--;
                map.put(b, N - 1);
                N--;
            }
        }
        
        r = new Random();
    }
    
    public int pick() {
        int p = r.nextInt(len);
        // int p = (int) (Math.random()*len);
        if (map.containsKey(p))
            return map.get(p);
        return p;
    }
}