// https://leetcode.com/problems/reverse-vowels-of-a-string

class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        int st=0, ed=s.length()-1;
        
        char[] arr = s.toCharArray();
        
        while(st<ed){
            
            if(!set.contains(s.charAt(st)))
                st++;
            
             if(!set.contains(s.charAt(ed)))
                ed--;
            
            char temp = arr[st];
            arr[st]= arr[ed];
            arr[ed]=temp;
            st++;
            ed--;
        }
        
        return new String(arr);
        
        
    }
}