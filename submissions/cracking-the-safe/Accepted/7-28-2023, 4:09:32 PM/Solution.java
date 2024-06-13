// https://leetcode.com/problems/cracking-the-safe

class Solution {
    public String crackSafe(int n, int k) {
        
        
        //https://www.youtube.com/watch?v=fjxhMLJjC3Y
        
        Map<String, Integer> map = new HashMap<>();
        String ans = "";
        for(int i=0; i<n-1; i++){ 
            ans+="0";
        }
         
        
        for(int i=0; i<Math.pow(k, n); i++){
            String key = ans.substring(ans.length()-(n-1));  //前n-1個當key
            
            map.put(key, (map.getOrDefault(key, 0)+1)%k);  //找下一個value
            ans += map.get(key);
        }
        
        return ans;
        
    }
}