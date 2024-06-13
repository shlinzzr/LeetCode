// https://leetcode.com/problems/determine-if-string-halves-are-alike

class Solution {
    public boolean halvesAreAlike(String s) {
        
        List<Character> list = new ArrayList<>();
        char[] ca = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(char c: ca){
            list.add(c);
        }
        
        
        
        int len=s.length(), cnt=0;
        int v=0;
        for(char c : s.toCharArray()){
             if(list.contains(c)){
                 if(cnt<len/2)
                    v++;
                 else
                    v--;
             }
            
            cnt++;
        }
        
        System.out.println(list.contains('A'));
        
        return v==0;
        
        
        
//         for(char c: ca){
//             System.out.println("c="+c + " arr=" + arr[c-'A']);
//             if(arr[c-'A']!=0)
//                 return false;
//         }
        
//         return true;
    }
}