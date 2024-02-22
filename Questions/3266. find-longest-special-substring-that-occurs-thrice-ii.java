// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii

class Solution {
    public int maximumLength(String s) {
        // 1. n+2
        // 2. n+1, n
        // 3. n n n 
        
        
        HashMap<String, Integer> map = new HashMap<>();
        
            
        int ed=0;
        for(int st=0; st<s.length(); st++){
            
            while(ed<s.length() && s.charAt(ed)==s.charAt(st))
                ed++;
            
             // System.out.println(st + " " +ed);
            String sub = s.substring(st, ed);
            
           
            map.put(sub, map.getOrDefault(sub,0)+1);
            
            st=ed-1;
        }
        
        
        int max= 0;
        for(String k : map.keySet()){
            int cnt = map.get(k);
            
            if(cnt>=3)
                max = Math.max(max, k.length());
            
            if(map.getOrDefault(k.substring(1), 0)>=1 || cnt>=2)
                max = Math.max(max, k.length()-1);
            
            if(k.length()>=3)
                max = Math.max(max, k.length()-2);
        }
        
        return max==0 ? -1 : max;
    }
}