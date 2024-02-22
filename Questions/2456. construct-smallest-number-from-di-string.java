// https://leetcode.com/problems/construct-smallest-number-from-di-string

class Solution {
    public String smallestNumber(String pattern) {
        List<String> list = new ArrayList<>();
        
        boolean[] used = new boolean[10];
        
        helper(pattern, -1, list, "", used);
        
        Collections.sort(list, (l1,l2) -> Integer.valueOf(l1) - Integer.valueOf(l2));
        
        return list.get(0);
        
        
    }
    
    private void helper(String pattern, int idx, List<String>list, String curr, boolean[] used){
        
        if(curr.length() == pattern.length()+1){
            list.add(curr);   
            return;
        }
        
        
        for(int i=1; i<=9; i++){
            
            if( used[i]==true)
                continue;
            
            if(idx==-1){
                used[i]=true;
                helper(pattern, idx+1, list, curr+i, used);
                used[i]=false;
                
            }else{
                
                if(pattern.charAt(idx)=='D'){
                    if(i<curr.charAt(idx)-'0'){
                        used[i]=true;
                        helper(pattern, idx+1, list,curr+i, used);
                        used[i]=false;
                    }
                    
                }else{
                     if(i>curr.charAt(idx)-'0'){
                        used[i]=true;
                        helper(pattern, idx+1, list, curr+i, used);
                        used[i]=false;
                    }
                }
            }
                
            
            
        }
        
        
    }
    
}