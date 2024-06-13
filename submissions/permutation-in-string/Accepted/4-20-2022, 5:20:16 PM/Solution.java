// https://leetcode.com/problems/permutation-in-string

class Solution {
    
    // Brute force 
    // time : O(s1.length! * (s2.length-s1.length+1))
    // Space : O(s1.length)
    
    
    
    
//     public boolean checkInclusion(String s1, String s2) {
        
//         List<String> perm = new ArrayList<>();
//         perm = permute("", s1, perm);
        
//         for(String p : perm){
//             if(s2.contains(p))
//                 return true;
//         }
        
        
//         return false;
//     }
    
//     private List<String> permute(String prefix, String postfix, List<String> perm){
        

//         if(postfix.length()==0){
//             perm.add(prefix);
//             // System.out.println(prefix);
            
//         }else{
//             for(int i=0;i<postfix.length(); i++){
//                 permute(  prefix+postfix.charAt(i)
//                         , postfix.substring(0, i) + postfix.substring( i+1 , postfix.length())
//                         , perm);
//             }
//         }
//         return perm;
//     }
    
    
    // sliding window
    // time O(26 * (s2.length - s1.length ) + s1.length)
    // space = O (26*2) = O(1)
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        
        HashMap<Character,Integer> map = new HashMap<>();
        int ls1 = s1.length(),ls2 = s2.length();
        for(int i=0;i<ls1;i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        for(int i=0;i<=ls2-ls1;i++){
            String str = s2.substring(i,i+ls1);
            HashMap<Character,Integer> maps2 = new HashMap<>();
            for(int j=0;j<ls1;j++){                
                maps2.put(str.charAt(j),maps2.getOrDefault(str.charAt(j),0)+1);
            }
            if(map.equals(maps2)) return true;            
        }
        return false;
    }
    
    
}