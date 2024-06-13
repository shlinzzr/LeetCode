// https://leetcode.com/problems/permutation-in-string

// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
        
//         List<String> list1 = new ArrayList<>();
//         for(char ss : s1.toCharArray()){
//             list1.add(String.valueOf(ss));
//         }
        
//         char[] chArr = s2.toCharArray();
//         for(int c=0; c<chArr.length-s1.length()+1; c++){
            
//             if(list1.contains(String.valueOf(chArr[c]))){
                
//                 List<String> copy = new ArrayList<>();
//                  for(char ss : s1.toCharArray()){
//                     copy.add(String.valueOf(ss));
//                 }
               
//                 boolean res = true;
                
//                 for(int i=0; i<list1.size(); i++){
                
//                     if(!copy.contains(String.valueOf(chArr[i+c]))){
//                         res = false;
//                         break;
//                     }
                    
//                     copy.remove(String.valueOf(chArr[i+c]));
//                 }
                
//                 if(res) 
//                     return true;
//             }
            
            
//         }
        
//         return false;
        
//     }
// }


public class Solution {
    boolean flag = false;
    
    public boolean checkInclusion(String s1, String s2) {
        permute(s1, s2, 0);
        return flag;
    }
    
    public String swap(String s, int i0, int i1) {
        if (i0 == i1)
            return s;
        String s1 = s.substring(0, i0);
        String s2 = s.substring(i0 + 1, i1);
        String s3 = s.substring(i1 + 1);
        return s1 + s.charAt(i1) + s2 + s.charAt(i0) + s3;
    }
    
    void permute(String s1, String s2, int l) {
        if (l == s1.length()) {
            if (s2.indexOf(s1) >= 0)
                flag = true;
        } else {
            for (int i = l; i < s1.length(); i++) {
                s1 = swap(s1, l, i);
                permute(s1, s2, l + 1);
                s1 = swap(s1, l, i);
            }
        }
    }
}