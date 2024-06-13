// https://leetcode.com/problems/longest-substring-without-repeating-characters

// class Solution { // 116ms
//     public int lengthOfLongestSubstring(String s) {
        
//         int max = 0;
//         for(int i=0; i<s.length(); i++){
            
//             HashSet<Character> set = new HashSet<>();
            
//             for(int j=i; j<s.length(); j++){
                
//                 if(set.contains(s.charAt(j))){
//                     break;
//                 }
                
//                 set.add(s.charAt(j));
                
//             }
            
//             if(set.size()>max)
//                 max = set.size();
            
            
//         }
        
//         return max;
//     }
// }

// class Solution {  //  11ms
//     public int lengthOfLongestSubstring(String s) {
        
//         int max = 0;
        
//         HashMap<Character, Integer> map = new HashMap<>();
        
//         for(int i=0, j=0; i<s.length(); i++){
            
//              // i=0, i=1, i=2, i=3
            
//             if(map.containsKey(s.charAt(i))){ // a, b
//                 j = Math.max(j, map.get(s.charAt(i))+1);  // j=2,  j=1
//             }
            
//             map.put(s.charAt(i), i);   // (a,0) (b,1)->(b,2)
//             max = Math.max(max , i-j+1);
                
//         }
        
//         return max;
//     }
// }

class Solution {  //  1ms
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length()<=1)
            return s.length();
        
        int left=0, right=0, max = 0;
        int[] chars = new int[128];
        
        while(right < s.length()){

                        
            char c = s.charAt(right);
            if(chars[c] >0){
                left = Math.max(left, chars[c]);
            }
            
            max = Math.max(max , right-left+1); //1
            chars[c] = ++right;
        }
        
        return max;
    }
}