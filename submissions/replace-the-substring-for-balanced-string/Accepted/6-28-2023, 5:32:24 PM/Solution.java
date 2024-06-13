// https://leetcode.com/problems/replace-the-substring-for-balanced-string

class Solution {
    
    HashMap<Character, Integer> map = new HashMap<>();
    
    public int balancedString(String s) {
        // solution 1 binarySearch
        
        //  Q Q  [ W E R ] W E R 外面的字母數量如果比滑窗裡面的少,滑窗內可以補  
        //                       但如果比滑窗內的還大,那這個滑窗就沒救了 一定要擴大
        
        int len = s.length();
        
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        boolean flag = true;
        for(Map.Entry<Character, Integer> en : map.entrySet()){
            if(en.getValue()!=len/4)
                flag=false;
        }
        if(flag)
            return 0;
        
        int left = 1, right=len;
        while(left<right){
            
            int mid = left + (right-left)/2;
            
            if(isOK(mid, s)){
                right = mid;
            }else
                left = mid+1;
        }
        return left;
    }
    
    
    private boolean isOK(int k, String s){
        
        int len = s.length();
        HashMap<Character, Integer> curr = new HashMap<>();
        
        for(int i=0; i<len; i++){
            
            char ch = s.charAt(i);
            curr.put(ch, curr.getOrDefault(ch, 0)+1);
            if(i>=k){
                curr.put(s.charAt(i-k), curr.getOrDefault(s.charAt(i-k), 0)-1);
            }
            
            
            boolean ok = true;
            for(char chh : map.keySet()){
                if(map.get(chh) - curr.getOrDefault(chh,0)>len/4){
                    ok = false;
                    break;
                }
            }
            if(ok)
                return true;
        }
        
        return false;
        
        
    }
}