// https://leetcode.com/problems/scramble-string

class Solution {

    static HashMap<String,Boolean> hp;

    static boolean helper(String s1, String s2){
        if(s1.equals(s2)) return true;

        String key = s1+" "+s2;

        if(hp.containsKey(key)) return hp.get(key);

        int n = s1.length();
        int count[] = new int[26];
        for(int i=0; i<n; i++){
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }

        for(int i=0; i<26; i++){
            if(count[i]!=0){
                hp.put(key,false);
                return false;
            } 
        }

        for(int i=1; i<n; i++){
            if((helper(s1.substring(0,i),s2.substring(0,i)) && helper(s1.substring(i),s2.substring(i))) || (helper(s1.substring(0,i),s2.substring(n-i)) && helper(s1.substring(i),s2.substring(0,n-i)))){
                hp.put(key,true);
                return true;
            }
        }
        hp.put(key,false);
        return false;
    }
    public boolean isScramble(String s1, String s2) {
        hp = new HashMap<>();
        return helper(s1,s2);
    }
}