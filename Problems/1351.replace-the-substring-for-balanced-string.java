// https://leetcode.com/problems/replace-the-substring-for-balanced-string

class Solution {
    
    int[] arr = new int[4];
    
    public int balancedString(String s) {
        
        // solution 2 sliding window
        int min = Integer.MAX_VALUE;
        
        int len = s.length();
        
        for(char ch : s.toCharArray()){
            arr[ getIdx(ch) ]++;
        }
        
        boolean flag = true;
        for(int a: arr){
            if(a!=len/4)
                flag=false;
        }
        if(flag) return 0;
        
        
        int[] cur = new int[4];
        
        int st = 0;
        for(int ed=0; ed<len; ed++){
            
            char ch = s.charAt(ed);
            int idx = getIdx(ch);
            cur[idx]++;
            
            while(st<=ed && isOK(arr, cur, len)){
                
                min = Math.min(min ,ed-st+1);
                int stIdx = getIdx(s.charAt(st));
                cur[stIdx]--;
                st++;
            }
            
            
        }
        
        return min;
      
    }
    
    private int getIdx(char ch ){
        int idx =-1;
        
        if(ch=='Q')
                idx=0;
            else if(ch=='W')
                idx=1;
            else if(ch=='E')
                idx=2;
            else 
                idx=3;
        
        return idx;
    }
        
    private boolean isOK(int[] arr, int[] cur, int len){
        for(int i=0; i<4; i++){
            if(arr[i]-cur[i]>len/4)
                return false;
        }
        return true;
    }
        
        
        
        
//         // solution 1 binarySearch 5.98% 
           // T(nlgn) 
           // S(n)
//         //  Q Q  [ W E R ] W E R 外面的字母數量如果比滑窗裡面的少,滑窗內可以補  
//         //                       但如果比滑窗內的還大,那這個滑窗就沒救了 一定要擴大
        
//         int len = s.length();
        
//         for(char ch : s.toCharArray()){
//             map.put(ch, map.getOrDefault(ch, 0)+1);
//         }
        
//         boolean flag = true;
//         for(Map.Entry<Character, Integer> en : map.entrySet()){
//             if(en.getValue()!=len/4)
//                 flag=false;
//         }
//         if(flag)
//             return 0;
        
//         int left = 1, right=len;
//         while(left<right){
            
//             int mid = left + (right-left)/2;
            
//             if(isOK(mid, s)){
//                 right = mid;
//             }else
//                 left = mid+1;
//         }
//         return left;
//     }
    
    
//     private boolean isOK(int k, String s){
        
//         int len = s.length();
//         HashMap<Character, Integer> curr = new HashMap<>();
        
//         for(int i=0; i<len; i++){
            
//             char ch = s.charAt(i);
//             curr.put(ch, curr.getOrDefault(ch, 0)+1);
//             if(i>=k){
//                 curr.put(s.charAt(i-k), curr.getOrDefault(s.charAt(i-k), 0)-1);
//             }
            
            
//             boolean ok = true;
//             for(char chh : map.keySet()){
//                 if(map.get(chh) - curr.getOrDefault(chh,0)>len/4){
//                     ok = false;
//                     break;
//                 }
//             }
//             if(ok)
//                 return true;
//         }
        
//         return false;
    // }
}