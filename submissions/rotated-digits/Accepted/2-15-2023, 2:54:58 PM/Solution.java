// https://leetcode.com/problems/rotated-digits

class Solution {
    public int rotatedDigits(int n) {
        
        int cnt=0;
        for(int i=1; i<=n; i++){
            
           if(confusingNumber(i)){
               // System.out.println(i);
               cnt++;
           }
               
        }
        
        return cnt;
        
    }
    
    
     private boolean confusingNumber(int n) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('2', '5');
        map.put('5', '2');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        
        Set<Character> set = new HashSet<>();
        set.add('3');
        set.add('4');
        set.add('7');
        
        String s = String.valueOf(n);
        
        for(char ch : s.toCharArray()){
            if(set.contains(ch))
                return false;
        }
        
        
        StringBuilder sb = new StringBuilder(s);
        char[] arr = sb.toString().toCharArray();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                arr[i] = map.get(arr[i]);
            }
        }
        
        int rev = Integer.valueOf(String.valueOf(arr));
        
        if(rev==n)
            return false;
        else 
            return true;
        
    }
}