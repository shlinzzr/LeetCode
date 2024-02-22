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


        // devide to 2 part :
        // left s1 = 

        /*
        let s1 = 

         * S1 [ xxxxx | ooooooooo ]
		 *    0       i             n   
		 * 
		 * here we have two possibilities:
		 *      
		 * S2 [ xxxxx | ooooooooo ]
		 *    0       i            n
		 *    
		 * or 
		 * 
		 * S2 [ ooooooooo | xxxxx ]
		 *               n-i     
		 * 
         */
        for(int i=1; i<n; i++){
            if((isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i))) 
            || (isScramble(s1.substring(0,i),s2.substring(n-i)) && isScramble(s1.substring(i),s2.substring(0,n-i)))){
                map.put(key,true);
                return true;
            }
        }

        map.put(key, false);
        return false;
    }

}