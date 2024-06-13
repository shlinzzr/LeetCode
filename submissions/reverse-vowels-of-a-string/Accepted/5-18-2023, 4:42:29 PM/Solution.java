// https://leetcode.com/problems/reverse-vowels-of-a-string

class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        
        int len = s.length();
        
        int st =0, ed=len-1;
        
        char[] arr  = s.toCharArray();
        
        while(st<ed){
            
            while(st<len && !set.contains(s.charAt(st)))
                st++;
            
            while(ed>0 && !set.contains(s.charAt(ed)))
                ed--;
            
            
            if(st<ed){
                
                char tmp = arr[st];
                arr[st] = arr[ed];
                arr[ed] = tmp;
                st++;
                ed--;
            }
        }
        
        return new String(arr);
            
                
            
    }
}