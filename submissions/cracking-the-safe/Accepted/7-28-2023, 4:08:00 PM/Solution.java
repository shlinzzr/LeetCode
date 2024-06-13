// https://leetcode.com/problems/cracking-the-safe

class Solution {
    public String crackSafe(int n, int k) {
        
        
        Map<String, Integer> map = new HashMap<>();
        String ans = "";
        for(int i=0; i<n-1; i++){
            ans+="0";
        }
         
        System.out.println(ans );
        // 01234 5-
        
        for(int i=0; i<Math.pow(k, n); i++){
            String key = ans.substring(ans.length()-(n-1));
            
            
            map.put(key, (map.getOrDefault(key, 0)+1)%k);
            ans += (map.get(key));
        }
        
        return ans;
        
    }
}