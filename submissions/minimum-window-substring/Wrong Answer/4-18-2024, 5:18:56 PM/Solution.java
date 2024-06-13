// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {

        if(s.length()<t.length()) return "";
        

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        String res = s;
        

        char[] arr = s.toCharArray();

        int st =0 ;
        for(int i=0; i<s.length(); i++){
            char ch = arr[i];
            if(!map.containsKey(ch)) continue;
            
            while(i<arr.length && (i<t.length() || !isValid(map))){

                if(map.containsKey(arr[i]))
                    map.put(arr[i], map.get(arr[i])-1);
                i++;
            }
            
           
            // if(i-st+1 < res.length()){
            //     res = s.substring(st, i);
            // }

            System.out.println(s.substring(st, i));

            while(st<s.length() && isValid(map)){
                System.out.println(s.substring(st, i) + " in");
                if(i-st+1 < res.length()){
                    res = s.substring(st, i);
                }


                if(map.containsKey(arr[st]))
                    map.put(arr[st], map.get(arr[st])+1);
                st++;
            }
            

        }
        return res;

    }

    private boolean isValid(Map<Character, Integer> map){
        for( char ch : map.keySet()){
            if(map.get(ch )>0) return false;
        }   
        return true;
    }
}