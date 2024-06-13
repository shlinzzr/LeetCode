// https://leetcode.com/problems/cracking-the-safe

class Solution {
    public String crackSafe(int n, int k) {
        
        
        // 123...n
        // xxxxxx x, x= 0~k-1: k個 possible
        // | n-1 | x 前n-1個當key
        
        // ans = "0000000"
        //       |  n-1  |
        // n=4, k=4
        // ...
        // ans= 00 011
        //.       |   | 取最後 n-2個當key
        
        //https://www.youtube.com/watch?v=fjxhMLJjC3Y
        
        
        String ans = "";
        for(int i=0; i<n-1; i++){ 
            ans+="0";
        }
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<Math.pow(k, n); i++){
            String key = ans.substring(ans.length()-(n-1));  //前n-1個當key
            
            map.put(key, (map.getOrDefault(key, 0)+1)%k);  //找下一個
            
            System.out.println("i=" + i + " ans=" + ans + " key=>" + key);
            
            ans += map.get(key);
        }
        
        return ans;
        
    }
}