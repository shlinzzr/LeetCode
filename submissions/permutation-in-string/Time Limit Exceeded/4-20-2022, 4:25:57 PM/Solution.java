// https://leetcode.com/problems/permutation-in-string

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        List<String> perm = new ArrayList<>();
        perm = permute("", s1, perm);
        
        for(String p : perm){
            if(s2.contains(p))
                return true;
        }
        
        
        return false;
    }
    
    private List<String> permute(String prefix, String postfix, List<String> perm){
        

        if(postfix.length()==0){
            perm.add(prefix);
            System.out.println(prefix);
            
        }else{
            
            for(int i=0;i<postfix.length(); i++){
                
                permute(  prefix+postfix.charAt(i)
                        , postfix.substring(0, i) + postfix.substring( i+1 , postfix.length())
                        , perm);
            }
            
        }
        
       
        return perm;
        
    }
}