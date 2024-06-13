// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int left = 0;
        int currLen = 0;
        int minLen = Integer.MAX_VALUE;

        char[] arr = s.toCharArray();

        int st =0 ;
        for(int i=0; i<s.length(); i++){
            char ch = arr[i];
            if(!map.containsKey(ch)) continue;
            map.put(arr[i], map.get(arr[i])-1); 

            if(map.get(ch)>=0) 
                currLen++;

            while(currLen==t.length()){

                //update ans
                if(i-st+1 < minLen){
                    minLen = i-st+1;
                    left = st;
                }


                if(map.containsKey(arr[st])){
                    map.put(arr[st], map.get(arr[st])+1);
                    if(map.get(arr[st])>0)
                        currLen--;
                }
                st++;
            }
        }

        return minLen== Integer.MAX_VALUE ? "" : s.substring(left, left+minLen);

    }

    private boolean isValid(Map<Character, Integer> map){
        for( char ch : map.keySet()){
            if(map.get(ch )>0) return false;
        }   
        return true;
    }
}