// https://leetcode.com/problems/string-compression-ii

class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int[] arr = new int[26];
        int len = s.length();
        for(int i=0; i<len;i++){
             char c = s.charAt(i);
             arr[c-'a']++;

        }
        
        while(k>0){
            int idx = findMin(arr);
            System.out.println(idx);
            arr[idx]--;
            k--;
        }
        
        int res=0;
        
        for (int i=0; i<26; i++){
            if(arr[i]==1)
                res++;
            else if (arr[i]>0)
                res+=String.valueOf(arr[i]).length()+1;

        }
        
        return res;
    }


private int findMin(int[] arr){
    int min = Integer.MAX_VALUE;
    int idx =0;
    
    for (int i=0; i<26; i++){
        int n=arr[i];
        
        if((arr[i]!=0 && arr[i]%10==0 )|| arr[i]==1)
            return i;
        
         if(n<min&&n!=0){
             min=n;
             idx=i;
         }

    }
    
    return idx;
}
}