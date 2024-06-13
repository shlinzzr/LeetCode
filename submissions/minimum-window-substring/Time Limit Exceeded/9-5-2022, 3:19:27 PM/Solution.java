// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        
        // bf
        int[] arr = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            HashMap<Character, Integer> cp = new HashMap<>(map);
            
            for(int j=i; j<s.length(); j++){
                char c = s.charAt(j);
                if(cp.containsKey(c) && cp.get(c)>0){

                    if(cp.get(c)==1)
                        cp.remove(c);
                    else
                        cp.put(c, cp.get(c)-1);
                    
                    if(cp.size()==0){
                        arr[i] = j-i+1;
                        break;
                    }
                        
                }                
            }
        }
        
        String res ="";
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(min>arr[i] && arr[i]!=0){
                min = arr[i];
                res = s.substring(i, i+min);
            }
        }
        
        return res;
    
        
    }       
}