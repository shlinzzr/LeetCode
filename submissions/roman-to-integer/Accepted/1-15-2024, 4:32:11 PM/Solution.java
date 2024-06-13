// https://leetcode.com/problems/roman-to-integer

class Solution {
    public int romanToInt(String s) {
        int len = s.length();
        
        int[] arr = new int[len+1];
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int res =0 ;
        for(int i=0; i<len; i++){
            arr[i] = map.get(s.charAt(i));
        }
        
        for(int i=0; i<len-1; i++){
            if(arr[i+1]>arr[i]){
                res-=arr[i];
            }else{
                res+=arr[i];
            }
        }
        
        return res+arr[len-1];
    }
}