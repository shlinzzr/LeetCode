// https://leetcode.com/problems/unique-email-addresses

class Solution {
    
    int[] parent;
    public int numUniqueEmails(String[] emails) {
        
        
        int len = emails.length;
        
        parent = new int[len];
        for(int i=0;i<len; i++){
            parent[i] = i;
        }
        
        Map<String, Integer> map = new HashMap<>();
        
        int cnt = len;
        for(int i=0; i<len; i++){
            
            String s = emails[i];
            
            String[] arr = s.split("@");
            String local = arr[0];
            
            local = local.replaceAll("\\.", "");
            int idx = local.indexOf("+");
            if(idx>0){
                local = local.substring(0, idx);
            }
            local = local +"@"+ arr[1];
            
            // System.out.println(local);
            
            if(!map.containsKey(local)){
                map.put(local, i);    
            }else{
                cnt--;
            }
            
        }
        return cnt;
        
    }
}