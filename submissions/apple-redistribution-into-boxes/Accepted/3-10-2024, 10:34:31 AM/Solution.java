// https://leetcode.com/problems/apple-redistribution-into-boxes

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        
        Arrays.sort(capacity);
        
        int sum = 0;
        
        for(int a : apple){
            sum+=a;
        }
        
        int m = capacity.length;
        
        int idx=m-1;
        int cnt=  0;
        while(sum>0){
            sum-= capacity[idx--];
            cnt++;
        }
        return cnt;
        
    }
}