// https://leetcode.com/problems/scramble-string

class Solution {
    HashMap<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        if(s1.equals(s2)) return true;

        String key = s1+" "+s2;

        if(map.containsKey(key)) return map.get(key);
        
        int n = s1.length();
        int[] arr = new int[26];
        for(int i=0; i<n; i++){
            arr[s1.charAt(i)-'a']++;
            arr[s2.charAt(i)-'a']--;
        }

        for(int i=0; i<26; i++){
            if(arr[i]!=0){
                map.put(key, false);
                return false;
            } 
        }

        // s1.left==s2.left && 
        for(int i=1; i<n; i++){

            String s1_left = s1.substring(0,i);
            String s2_left = s2.substring(0,i);
            String s1_right = s1.substring(i);
            String s2_right = s2.substring(i);

            // if((isScramble(s1_left, s2_left)  && isScramble(s1_right, s2_right)) 
            // || (isScramble(s1_left, s2_right) && isScramble(s1_right, s2_left))){
            if((isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i))) 
            || (isScramble(s1.substring(0,i),s2.substring(n-i)) && isScramble(s1.substring(i),s2.substring(0,n-i)))){
                map.put(key,true);
                return true;
            }
        }

        return false;
    }

}