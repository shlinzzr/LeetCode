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
    
    
    private boolean isOk(String s, String p, int k, HashMap<Integer, Integer> map){
        
        int i=0, j=0;
        
        while(j<p.length()){ //p
            
            while(i<s.length() && s.charAt(i)!=p.charAt(j)){ //go through s
                i++;
            }
            
            if(i>=s.length()) break;
            
            if(!map.containsKey(i) || map.get(i)>=k) // 1.如果不是removable by pass, 2.k個之後bypass (只選前k個做rm)
                j++; // go p;
            
            i++;
        }
        
        return j==p.length();
    }
}