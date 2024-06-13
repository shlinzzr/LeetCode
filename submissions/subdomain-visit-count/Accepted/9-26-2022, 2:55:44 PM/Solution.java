// https://leetcode.com/problems/subdomain-visit-count

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
         List<String>  res = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String dm : cpdomains){
            
            String[] cntAndDm = dm.split(" ");
            int cnt = Integer.valueOf(cntAndDm[0]);
            
            String[] arr = cntAndDm[1].split("\\.");
            String cur = "";
            for(int i=arr.length-1; i>=0; i--){
                
                if(!cur.isEmpty())
                    cur="."+cur;
                    
                cur = arr[i]+cur;
                map.put(cur, map.getOrDefault(cur, 0) + cnt);
            }
        }
        
        
        for(Map.Entry<String, Integer> en : map.entrySet()){
            String s = en.getValue() + " " + en.getKey();
            res.add(s);
        }
        
        return res;
    }
}