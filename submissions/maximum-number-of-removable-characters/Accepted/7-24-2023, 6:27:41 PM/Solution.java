// https://leetcode.com/problems/maximum-number-of-removable-characters

class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int len = removable.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            map.put(removable[i], i);
        }
       
        int st=0, ed=len;
        while(st<ed){
            int mid = st + (ed-st+1)/2;
            
            if(isOk(s, p, mid, map)){
                st = mid;
                
            }else{
                ed = mid-1;
            }
        }
        
        return st;
        
    }
    
    
    private boolean isOk(String s, String p, int cnt, HashMap<Integer, Integer> map){
        
        int i=0, j=0;
        
        while(j<p.length()){
            
            while(i<s.length() && s.charAt(i)!=p.charAt(j)){
                i++;
            }
            
            if(i>=s.length()) break;
            
            if(!map.containsKey(i) || map.get(i)>=cnt)
                j++;
            
            i++;
        }
        
        return j==p.length();
    }
}