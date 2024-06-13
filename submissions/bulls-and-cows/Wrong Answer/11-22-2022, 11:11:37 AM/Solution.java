// https://leetcode.com/problems/bulls-and-cows

class Solution {
    public String getHint(String secret, String guess) {
        
        int[] arr = new int[10];
        
        Arrays.fill(arr, -1);
        
        for(char c : secret.toCharArray()){
            if(arr[c-'0']==-1)
                arr[c-'0']=0;
            arr[c-'0']++;
        }
        
        for(char c : guess.toCharArray()){
            arr[c-'0']--;
        }
        
        
        int bulls =0;
        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i)==guess.charAt(i))
                bulls++;
        }
        
        int z=0;
        for(int a : arr){
            if(a==0)
                z++;
        }
        
        int cows = z-bulls;
        
        return bulls + "A" + cows + "B";
        
        
    }
}