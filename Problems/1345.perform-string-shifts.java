// https://leetcode.com/problems/perform-string-shifts

class Solution {
    public String stringShift(String s, int[][] shift) {
        int left = 0, right=0;
        for(int[] a : shift){
            
            if(a[0]==0)
                left+=a[1];
            else
                right+=a[1];
        }
        
        int len = s.length();
        int mov = (right-left)%len;
        if(mov<0)
            mov+=len;
        
        // System.out.println(mov);
        
        char[] arr = reverse(s.toCharArray(), 0, len-1);
        // System.out.println(String.valueOf(arr));
        
        
        arr = reverse(arr, 0, mov-1);
        // System.out.println(String.valueOf(arr));
        arr = reverse(arr, mov, len-1);
        // System.out.println(String.valueOf(arr));
        
        
        return String.valueOf(arr);
        
        
        
    }
    
    private char[] reverse(char[] arr, int st, int ed){
        
        while(st<ed){
            swap(arr, st, ed);
            st++; 
            ed--;
        }
        
        return arr;
        
    }
    
    
    private void swap(char[] arr, int st, int ed){
        
        char temp = arr[st];
        arr[st] = arr[ed];
        arr[ed] =temp;
    }
}