// https://leetcode.com/problems/reverse-vowels-of-a-string

class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
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
        
        int st=0, ed=s.length()-1;
        
       // "a.b,."
        // ..b,a
           
        
        
        
        char[] arr = s.toCharArray();
        
        while(st<ed){
            
            while(!set.contains(s.charAt(st))&&st<s.length()-1 )
                st++;
            
             while(!set.contains(s.charAt(ed)) && ed>0  )
                ed--;
            
            if(st<ed){
                char temp = arr[st];
                arr[st]= arr[ed];
                arr[ed]=temp;
                st++;
                ed--;  
            }
            
            // System.out.println( new String(arr));
            
        }
        
        return new String(arr);
        
        
    }
}