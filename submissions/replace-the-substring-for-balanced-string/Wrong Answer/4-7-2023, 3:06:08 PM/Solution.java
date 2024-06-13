// https://leetcode.com/problems/replace-the-substring-for-balanced-string

class Solution {
    public int balancedString(String s) {
        int len = s.length();
        int target = len/4;
        
        int[] arr = new int[4];
        for(char ch : s.toCharArray()){
            
            if(ch=='Q')
                arr[0]++;
            else if(ch=='W')
                arr[1]++;
            else if(ch=='E')
                arr[2]++;
            else{
                arr[3]++;
            }
        }
        
        int cnt = 0;
        for(int a : arr){
            cnt+= Math.abs(a-target);
        }
        
        return cnt/2;
        
    }
}