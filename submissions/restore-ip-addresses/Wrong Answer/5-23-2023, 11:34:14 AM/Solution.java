// https://leetcode.com/problems/restore-ip-addresses

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        
        helper(s, list, new String[4], 0, 0);
        
        
        return list;
    }
    
    
    private void helper(String s, List<String> list, String[] curr, int dot, int st){
        
        if(dot==4 && st==s.length() && curr[3]!=null && Integer.valueOf(curr[3])<=255){
            list.add(curr[0]+"."+curr[1]+"."+curr[2]+"."+curr[3]);
            return;
        }
        
        if(dot==4)
            return ;
        
        for(int ed=st+1; ed<st+4 && ed<=s.length(); ed++){
            
            String sub = s.substring(st, ed);
            
            if(Integer.valueOf(sub)<=255){
                
                curr[dot]=sub;
                
                helper(s, list, curr, dot+1, ed);
            }
        }
        
        
        
    }
}